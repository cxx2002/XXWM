package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.R;
import com.cxx.reggie.dto.OrdersDto;
import com.cxx.reggie.pojo.OrderDetail;
import com.cxx.reggie.pojo.Orders;
import com.cxx.reggie.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单表(Orders)表控制层
 *
 * @author 陈喜喜
 * @since 2022-09-04 19:27:28
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 提交订单  支付订单
     *
     * @param orders 实体
     * @return 支付结果
     */
    @PostMapping("submit")
    public R<String> submit(@RequestBody Orders orders) {
        ordersService.submitOrders(orders);
        return R.success("下单成功！");
    }

    /**
     * 分页查询
     * public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
     * LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
     * queryWrapper.eq(OrderDetail::getOrderId, orderId);
     * queryWrapper.orderByDesc(OrderDetail::getAmount);
     * return orderDetailService.list(queryWrapper);
     * }
     *
     * @return 查询结果
     */
    @GetMapping("/userPage")
    public R<Page> userPage(int page, int pageSize) {
        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        Page<OrdersDto> pageDto = new Page<>(page, pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //这里直接把分页的全部结果查询出来，没有分页条件
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        this.ordersService.page(pageInfo, queryWrapper);

        //对OrderDto进行需要的属性赋值
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> orderDtoList = records.stream().map((item) -> {
            OrdersDto orderDto = new OrdersDto();
            //此时的orderDto对象里面orderDetails属性还是空 下面准备为它赋值
            Long orderId = item.getId();//获取订单id
            List<OrderDetail> orderDetailList = this.ordersService.getOrderDetailsByOrderId(orderId);
            BeanUtils.copyProperties(item, orderDto);
            //对orderDto进行OrderDetails属性的赋值
            orderDto.setOrderDetails(orderDetailList);
            return orderDto;
        }).collect(Collectors.toList());

        //使用dto的分页有点难度.....需要重点掌握
        BeanUtils.copyProperties(pageInfo, pageDto, "records");
        pageDto.setRecords(orderDtoList);
        return R.success(pageDto);
    }

    /**
     * 再来一单
     *
     * @param orders 实体  id
     * @return 支付结果
     */
    @PostMapping("again")
    public R<String> again(@RequestBody Orders orders) {
        Orders againOrders = new Orders();
        Orders onceOrders = ordersService.getById(orders.getId());
        BeanUtils.copyProperties(onceOrders, againOrders, "id", "number", "status");
        againOrders.setAddressBookId(onceOrders.getAddressBookId());
        ordersService.againOrders(againOrders);
        return R.success("再来一单");
    }


    /**
     * 后台订单管理页面
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @return {@link R}<{@link Page}>
     */
    @GetMapping("/page")
    public R<Page> showPage(int page, int pageSize, Long number, String beginTime, String endTime) {

        Page<Orders> ordersPage = new Page(page, pageSize);

        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(number != null, Orders::getNumber, number)
                .gt(StringUtils.isNotEmpty(beginTime), Orders::getOrderTime, beginTime)
                .lt(StringUtils.isNotEmpty(endTime), Orders::getOrderTime, endTime);

        ordersService.page(ordersPage, queryWrapper);
        return R.success(ordersPage);
    }

    /**
     * 编辑数据
     *
     * @param orders 实体
     * @return 编辑结果
     */
    @PutMapping
    public R<String> edit(@RequestBody Orders orders) {
        Orders ordersServiceById = ordersService.getById(orders.getId());
        ordersServiceById.setStatus(4);
        ordersService.updateById(ordersServiceById);
        return R.success("手动修改订单已送达");
    }

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
    //
    //
    //
    //

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Orders> queryById(@PathVariable("id") Long id) {
        return null;
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return null;
    }

}

