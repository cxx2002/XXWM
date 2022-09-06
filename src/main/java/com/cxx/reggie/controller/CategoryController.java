package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.pojo.Category;
import com.cxx.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜品及套餐分类(Category)表控制层
 *
 * @author 陈喜喜
 * @since 2022-08-21 11:10:00
 */
@Slf4j
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 新增数据
     *
     * @param category 实体
     * @return 新增结果
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        CategoryController.log.info("category:{}", category);
        categoryService.save(category);
        return R.success("新增分类成功！");
    }

    /**
     * 分页查询
     *
     * @param page     当前页数
     * @param pageSize 页面大小
     * @return 查询结果
     */
    @GetMapping("/page")
    public R<Page<Category>> queryByPage(int page, int pageSize) {
        Page<Category> pageInfo = new Page<>(page, pageSize);
        //分页条件构造器，用来按private Integer sort排序
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);

        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public R<String> deleteById(Long id) {
        CategoryController.log.info("删除分类，id={}", id);
        //categoryService.removeById(id)
        categoryService.remove(id);
        return R.success("分类信息删除成功！");
    }

    /**
     * 编辑数据
     *
     * @param category 实体
     * @return 编辑结果
     */
    @PutMapping
    public R<String> edit(@RequestBody Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getId, category.getId());
        categoryService.update(category, queryWrapper);
        return R.success("分类信息修改成功！");
    }


    /**
     * 根据type条件查询分类数据
     *
     * @param category 用来封装type
     * @return list
     */
    @GetMapping("/list")
    public R<List<Category>> queryById(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }


}

