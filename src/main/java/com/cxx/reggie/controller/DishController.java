package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.dto.DishDto;
import com.cxx.reggie.pojo.Category;
import com.cxx.reggie.pojo.Dish;
import com.cxx.reggie.pojo.DishFlavor;
import com.cxx.reggie.service.CategoryService;
import com.cxx.reggie.service.DishFlavorService;
import com.cxx.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理(Dish)表控制层
 *
 * @author 陈喜喜
 * @since 2022-08-22 16:32:46
 */
@Slf4j
@RestController
@RequestMapping("dish")
public class DishController {
    /**
     * 服务对象
     */
    @Resource
    private DishService dishService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private DishFlavorService dishFlavorService;

    /**
     * 新增数据
     *
     * @param dishDto 实体
     * @return 新增结果
     */
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        DishController.log.info(dishDto.toString());
        dishService.saveWithFlavor(dishDto);
        return R.success("新增菜品成功！ ");
    }

    /**
     * 分页查询
     *
     * @param pageSize 页面大小
     * @param page     分页对象
     * @param name     搜索条件
     * @return 查询结果
     */
    @GetMapping("/page")
    public R<Page<DishDto>> queryByPage(int page, int pageSize, String name) {
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> pageDtoInfo = new Page<>(page, pageSize);

        //分页条件构造器，根据更新时间降序排序
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        queryWrapper.like(name != null, Dish::getName, name);
        dishService.page(pageInfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, pageDtoInfo, "records");
        List<Dish> records = pageInfo.getRecords();
        /*
            先让把除了categoryName的参数拷贝过去(DishDto继承了父类Dish，有Dish的全部属性)，
            再根据id查数据库categoryName给DishDto，最后收集起来用list接收
         */
        List<DishDto> list = records.stream().map(item -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());

        pageDtoInfo.setRecords(list);
        return R.success(pageDtoInfo);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据DishDto
     */
    @GetMapping("{id}")
    public R<DishDto> queryById(@PathVariable("id") Long id) {
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    /**
     * 编辑数据
     *
     * @param dishDto 实体
     * @return 编辑结果
     */
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto) {
        dishService.updateWithFlavor(dishDto);
        return R.success("信息修改成功！");
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public R<String> deleteById(@RequestParam List<Long> id) {
        dishService.removeBatchByIds(id);
        return R.success("删除成功！");
    }

    // 改变菜品的销售状态

    @PostMapping("/status/{status}")
    public R<String> updateSaleStatus(@PathVariable("status") Integer status, @RequestParam List<Long> id) {
        //  菜品具体的售卖状态 由前端修改并返回，该方法传入的status是 修改之后的售卖状态，可以直接根据一个或多个菜品id进行查询并修改售卖即可
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(id != null, Dish::getId, id);

        List<Dish> list = dishService.list(queryWrapper);
        if (list != null) {
            list.forEach(dish -> dishService.updateStatusById(status, dish.getId()));
            return R.success("菜品的售卖状态已更改！");
        }
        return R.error("售卖状态不可更改,请联系管理员或客服！");

    }

    /**
     * 通过categoryId查询dish集合
     *
     * @param dish 封装前端传过来的categoryId数据
     * @return dishes对应的菜品集合
     */
    @GetMapping("/list")
    public R<List<DishDto>> queryDishById(Dish dish) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getCategoryId, dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus, 1);
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> dishes = dishService.list(queryWrapper);

        List<DishDto> dishDtoList = dishes.stream().map(item -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(DishFlavor::getDishId, item.getId());
            List<DishFlavor> list = dishFlavorService.list(lambdaQueryWrapper);
            dishDto.setFlavors(list);
            return dishDto;
        }).collect(Collectors.toList());

        return R.success(dishDtoList);
    }
    /**
     * 通过categoryId查询dish集合
     *
     * @param dish 封装前端传过来的categoryId数据
     * @return dishes对应的菜品集合
     */
    /*@GetMapping("/list")
    public R<List<Dish>> queryDishById(Dish dish) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dish::getCategoryId, dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus, 1);
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> dishes = dishService.list(queryWrapper);

        return R.success(dishes);
    }*/
}

