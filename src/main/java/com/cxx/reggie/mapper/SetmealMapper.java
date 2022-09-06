package com.cxx.reggie.mapper;
import org.apache.ibatis.annotations.Param;

import com.cxx.reggie.pojo.Setmeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 陈喜喜
* @description 针对表【setmeal(套餐)】的数据库操作Mapper
* @createDate 2022-08-28 21:55:20
* @Entity com.cxx.reggie.pojo.Setmeal
*/
public interface SetmealMapper extends BaseMapper<Setmeal> {
    int updateStatusById(@Param("status") Integer status, @Param("id") Long id);

}




