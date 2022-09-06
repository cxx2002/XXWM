package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.pojo.ShoppingCart;
import com.cxx.reggie.service.ShoppingCartService;
import com.cxx.reggie.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 陈喜喜
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-09-02 21:34:59
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




