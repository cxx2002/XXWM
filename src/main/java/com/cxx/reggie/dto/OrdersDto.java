package com.cxx.reggie.dto;

import com.cxx.reggie.pojo.OrderDetail;
import com.cxx.reggie.pojo.Orders;
import lombok.Data;

import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-09-04 20:47
 */
@Data
public class OrdersDto extends Orders {
    private static final long serialVersionUID = 9071210746167539698L;
    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
}
