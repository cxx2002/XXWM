package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.mapper.OrderDetailMapper;
import com.cxx.reggie.pojo.OrderDetail;
import com.cxx.reggie.service.OrderDetailService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单明细表(OrderDetail)表控制层
 *
 * @author 陈喜喜
 * @since 2022-09-06 22:34:27
 */

@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
    /**
     * 服务对象
     */
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private OrderDetailMapper orderDetailMapper;

    /**
     * 分页查询
     *
     * @param orderDetail 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<OrderDetail>> queryByPage(OrderDetail orderDetail, PageRequest pageRequest) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrderDetail> queryById(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param orderDetail 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<OrderDetail> add(@RequestBody OrderDetail orderDetail) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param orderDetail 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<OrderDetail> edit(@RequestBody OrderDetail orderDetail) {
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

