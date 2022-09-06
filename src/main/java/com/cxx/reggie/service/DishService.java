package com.cxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxx.reggie.dto.DishDto;
import com.cxx.reggie.pojo.Dish;

/**
 * @author 陈喜喜
 * @description 针对表【dish(菜品管理)】的数据库操作Service
 * @createDate 2022-08-21 20:58:20
 */
public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，同时操作两张表，dish和dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新口味信息
    void updateWithFlavor(DishDto dishDto);

    //更改菜品售卖状态信息
    void updateStatusById(Integer status, Long id);

    
}
