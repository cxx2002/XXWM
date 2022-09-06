package com.cxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxx.reggie.pojo.OrderDetail;
import com.cxx.reggie.pojo.Orders;

import java.util.List;

/**
 * @author 陈喜喜
 * @description 针对表【orders(订单表)】的数据库操作Service
 * @createDate 2022-09-04 19:27:13
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 提交  用户下单
     *
     * @param orders 订单
     */
    void submitOrders(Orders orders);

    void againOrders(Orders orders);

    /**
     * 得到订单细节订单通过id
     *
     * @param orderId 订单id
     * @return {@link List}<{@link OrderDetail}>
     */
    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}
