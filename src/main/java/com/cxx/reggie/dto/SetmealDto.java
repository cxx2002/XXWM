package com.cxx.reggie.dto;

import com.cxx.reggie.pojo.Setmeal;
import com.cxx.reggie.pojo.SetmealDish;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-08-28 22:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SetmealDto extends Setmeal {

    private static final long serialVersionUID = -2088318790866308411L;
    
    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
