package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.dto.SetmealDto;
import com.cxx.reggie.mapper.SetmealMapper;
import com.cxx.reggie.pojo.Category;
import com.cxx.reggie.pojo.Setmeal;
import com.cxx.reggie.pojo.SetmealDish;
import com.cxx.reggie.service.CategoryService;
import com.cxx.reggie.service.SetmealDishService;
import com.cxx.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 套餐(Setmeal)表控制层
 *
 * @author 陈喜喜
 * @since 2022-08-28 21:56:10
 */
@RestController
@RequestMapping("setmeal")
@Slf4j
public class SetmealController {
    /**
     * 服务对象
     */
    @Resource
    private SetmealService setmealService;
    @Resource
    private SetmealMapper setmealMapper;
    @Resource
    private CategoryService categoryService;
    @Resource
    private SetmealDishService setmealDishService;

    /**
     * 分页查询
     *
     * @param pageSize 页面大小
     * @param page     分页对象
     * @param name     搜索条件
     * @return 查询结果
     */
    @GetMapping("/page")
    public R<Page<SetmealDto>> queryByPage(int page, int pageSize, String name) {
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);
        Page<SetmealDto> pageDtoInfo = new Page<>(page, pageSize);

        //分页条件构造器，根据更新时间降序排序
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        queryWrapper.like(name != null, Setmeal::getName, name);
        setmealService.page(pageInfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, pageDtoInfo, "records");
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map(item -> {
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(item, setmealDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());

        pageDtoInfo.setRecords(list);
        return R.success(pageDtoInfo);
    }

    @Cacheable(value = "setmealCache", key = "#setmeal.categoryId+'_'+#setmeal.status")
    @GetMapping("/list")
    public R<List<Setmeal>> queryDishById(Setmeal setmeal) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Setmeal::getCategoryId, setmeal.getCategoryId());
        queryWrapper.eq(Setmeal::getStatus, 1);
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> setmeals = setmealService.list(queryWrapper);

        return R.success(setmeals);
    }

    /**
     * 前台点击套餐显示菜品信息
     *
     * @param id id
     * @return {@link R}<{@link SetmealDto}>
     */
    @GetMapping("/dish/{id}")
    public R<SetmealDto> queryDishById(@PathVariable("id") Long id) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Setmeal::getId, id);
        queryWrapper.eq(Setmeal::getStatus, 1);
        Setmeal setmeal = setmealService.getOne(queryWrapper);

        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal, setmealDto);
        LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId, id);
        List<SetmealDish> setmealDishList = setmealDishService.list(setmealDishLambdaQueryWrapper);
        setmealDto.setSetmealDishes(setmealDishList);
        setmealDto.setCategoryName(setmeal.getName());

        return R.success(setmealDto);
    }

    /**
     * 修改在售状态
     *
     * @param status id
     * @return 新增结果
     */
    @CacheEvict(value = "setmealCache", allEntries = true)
    @PostMapping("/status/{status}")
    public R<String> updateSetmealStatus(@PathVariable("status") Integer status, @RequestParam List<Long> id) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(id != null, Setmeal::getId, id);
        List<Setmeal> list = setmealService.list(queryWrapper);
        if (list != null) list.forEach(item -> setmealMapper.updateStatusById(status, item.getId()));
        if (status == 0) return R.success("停售成功！");
        if (status == 1) return R.success("起售成功！");
        return R.error("出错啦！请联系客服人员！");
    }

    /**
     * 新增数据
     *
     * @param setmealDto 实体
     * @return 新增结果
     */
    @CacheEvict(value = "setmealCache", allEntries = true)
    @PostMapping
    public R<String> add(@RequestBody SetmealDto setmealDto) {
        SetmealController.log.info(setmealDto.toString());
        setmealService.saveWithDish(setmealDto);
        return R.success("套餐添加成功！");
    }

    /**
     * 通过主键查询单条数据  回显修改页面显示的数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<SetmealDto> queryById(@PathVariable("id") Long id) {
        SetmealDto setmealDto = setmealService.GetByIdWithDish(id);
        return R.success(setmealDto);
    }

    /**
     * 编辑数据
     *
     * @param setmealDto 实体
     * @return 编辑结果
     */

    @CacheEvict(value = "setmealCache", allEntries = true)
    @PutMapping
    public R<String> edit(@RequestBody SetmealDto setmealDto) {
        setmealService.updateWithDish(setmealDto);
        return R.success("修改成功！");
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @CacheEvict(value = "setmealCache", allEntries = true)
    @DeleteMapping
    public R<String> deleteById(@RequestParam List<Long> id) {
        setmealService.removeBatchByIds(id);
        return R.success("删除成功！");
    }

}

