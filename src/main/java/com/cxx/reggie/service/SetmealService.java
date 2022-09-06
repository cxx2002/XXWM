package com.cxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxx.reggie.dto.SetmealDto;
import com.cxx.reggie.pojo.Setmeal;

/**
 * @author 陈喜喜
 * @description 针对表【setmeal(套餐)】的数据库操作Service
 * @createDate 2022-08-28 21:55:20
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品关系，需要操作两张表setmeal和setmeal_dish
     * * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

    SetmealDto GetByIdWithDish(Long id);

    void updateWithDish(SetmealDto setmealDto);
}
