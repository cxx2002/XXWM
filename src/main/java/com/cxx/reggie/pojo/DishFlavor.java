package com.cxx.reggie.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜品口味关系表
 *
 * @author 陈喜喜
 * @TableName dish_flavor
 * <p>
 * 记入了菜品对应的有哪些口味，数据从前端先传入过来，后端加上菜品id，次表记录的是各个菜品对应的有什么口味
 */
@TableName(value = "dish_flavor")
@Data
public class DishFlavor implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 菜品
     */
    private Long dishId;

    /**
     * 口味名称
     */
    private String name;

    /**
     * 口味数据list
     */
    private String value;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * 是否删除
     * 不要逻辑删除，因为更新菜品的时候会重复，数据库主键唯一
     */
    /*@TableLogic*/
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}