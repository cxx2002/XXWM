package com.cxx.reggie.mapper;
import org.apache.ibatis.annotations.Param;

import com.cxx.reggie.pojo.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 陈喜喜
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-08-21 20:58:20
* @Entity com.cxx.reggie.pojo.Dish
*/
public interface DishMapper extends BaseMapper<Dish> {
    int updateStatusById(@Param("status") Integer status, @Param("id") Long id);

}




