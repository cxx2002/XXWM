package com.cxx.reggie.dto;

import com.cxx.reggie.pojo.Dish;
import com.cxx.reggie.pojo.DishFlavor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
/**
// * @author 陈喜喜
// * @date 2022-08-26 21:39
 // 前端传输到服务端的数据 和实体类中的属性 不是一一对应关系，
 //// 需要用到DTO(Data Transfer Object)对象，即数据传输对象，一般用于Controller和Service层之间的数据传输
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class DishDto extends Dish {
    private static final long serialVersionUID = 6738876472410528517L;
    //  Dish 不符合前端传过来的数据,需要将其转化为DishDto
    // flavors: 菜品对应的口味数据
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
