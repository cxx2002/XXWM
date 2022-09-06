package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.pojo.DishFlavor;
import com.cxx.reggie.service.DishFlavorService;
import com.cxx.reggie.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author 陈喜喜
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-08-22 16:31:39
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




