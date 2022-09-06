package com.cxx.reggie.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车
 *
 * @author 陈喜喜
 * @TableName shopping_cart
 * @date 2022/09/03
 */
@TableName(value = "shopping_cart")
@Data
public class ShoppingCart implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String image;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 菜品id
     */
    private Long dishId;

    /**
     * 套餐id
     */
    private Long setmealId;

    /**
     * 口味
     */
    private String dishFlavor;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    //@TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /*用于公共字段自动填充会填充createUser和UpdateUser就不用公共字段填充了，因为数据表里面没有相应的字段却又硬要填充的话就会报错*/
    /**
     * 更新时间
     */
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}