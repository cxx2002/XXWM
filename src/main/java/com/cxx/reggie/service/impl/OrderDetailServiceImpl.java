package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.pojo.OrderDetail;
import com.cxx.reggie.service.OrderDetailService;
import com.cxx.reggie.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 陈喜喜
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-09-04 19:27:13
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




