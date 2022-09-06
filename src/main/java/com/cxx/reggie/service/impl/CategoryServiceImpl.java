package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.common.CustomException;
import com.cxx.reggie.pojo.Category;
import com.cxx.reggie.pojo.Dish;
import com.cxx.reggie.pojo.Setmeal;
import com.cxx.reggie.service.CategoryService;
import com.cxx.reggie.mapper.CategoryMapper;
import com.cxx.reggie.service.DishService;
import com.cxx.reggie.service.SetmealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 陈喜喜
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2022-08-21 11:01:52
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Resource
    private DishService dishService;
    @Resource
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        //查询当前分类是否关联了菜品(逻辑外键)，如果已经关联，则抛出一个业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int countDish = (int) dishService.count(dishLambdaQueryWrapper);
        if (countDish > 0) {
            throw new CustomException("当前分类下有菜品，不是空分类，不能删除！");
        }
        //查询当前分类是否关联了套餐(逻辑外键)，如果已经关联，则抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int countSetMeal = (int) setmealService.count(setmealLambdaQueryWrapper);
        if (countSetMeal > 0) {
            throw new CustomException("当前分类下有套餐，不是空分类，不能删除！");
        }
        //都没有关联菜品或套餐，才可以进行删除
        super.removeById(id);
    }
}