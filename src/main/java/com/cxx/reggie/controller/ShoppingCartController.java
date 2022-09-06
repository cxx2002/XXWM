package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.reggie.common.BaseContext;
import com.cxx.reggie.common.R;
import com.cxx.reggie.mapper.ShoppingCartMapper;
import com.cxx.reggie.pojo.ShoppingCart;
import com.cxx.reggie.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 购物车(ShoppingCart)表控制层
 *
 * @author 陈喜喜
 * @since 2022-09-02 21:35:55
 */
@RestController
@RequestMapping("shoppingCart")
@Slf4j
public class ShoppingCartController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 根据type条件查询分类数据
     *
     * @return list
     */
    @GetMapping("/list")
    public R<List<ShoppingCart>> list() {

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());

        // 最晚下单的 菜品或套餐在购物车中最先展示
        queryWrapper.orderByDesc(ShoppingCart::getCreateTime);
        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);

        return R.success(list);
    }


    /**
     * 新增数据  添加购物车
     *
     * @param shoppingCart 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart) {
        //先设置用户id，指定当前是哪个用户的购物车数据
        shoppingCart.setUserId(BaseContext.getCurrentId());
        //查询当前菜品或套餐是否购物车已存在（区分不同口味）
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(shoppingCart.getDishId() != null, ShoppingCart::getDishId, shoppingCart.getDishId());
        queryWrapper.eq(shoppingCart.getDishId() != null, ShoppingCart::getDishFlavor, shoppingCart.getDishFlavor());
        queryWrapper.eq(shoppingCart.getSetmealId() != null, ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);
        //如果存在，就在原来的数量number加1
        if (cartServiceOne != null) {
            cartServiceOne.setUpdateTime(LocalDateTime.now());
            cartServiceOne.setNumber(cartServiceOne.getNumber() + 1);
            shoppingCartService.updateById(cartServiceOne);
        }
        //如果不存在，则添加到数据库，数据库购物车表number默认值为1
        else {
            shoppingCart.setUpdateTime(LocalDateTime.now());
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }
        return R.success(cartServiceOne);
    }

    /**
     * 删除此条购物车记录
     *
     * @param shoppingCart 用来接受菜品id
     * @return {@link R}<{@link ShoppingCart}>
     */
    @PostMapping("sub")
    public R<String> sub(@RequestBody ShoppingCart shoppingCart) {
        //先设置用户id，指定当前是哪个用户的购物车数据
        shoppingCart.setUserId(BaseContext.getCurrentId());
        //查询当前菜品或套餐是否购物车已存在（区分不同口味）
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(shoppingCart.getDishId() != null, ShoppingCart::getDishId, shoppingCart.getDishId());
        //queryWrapper.eq(shoppingCart.getDishId() != null, ShoppingCart::getDishFlavor, shoppingCart.getDishFlavor())
        queryWrapper.eq(shoppingCart.getSetmealId() != null, ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);
        ShoppingCart cartServiceOne = list.get(list.size() - 1);
        //如果存在，就在原来的数量number减1
        if (cartServiceOne != null) {
            if (cartServiceOne.getNumber() <= 1) {
                shoppingCartService.removeById(cartServiceOne.getId());
            } else {
                cartServiceOne.setUpdateTime(LocalDateTime.now());
                cartServiceOne.setNumber(cartServiceOne.getNumber() - 1);
                shoppingCartService.updateById(cartServiceOne);
            }
        }
        //如果不存在，则添加到数据库，数据库购物车表number默认值为1

        return R.success("删减成功！");
    }

    /**
     * 删除数据  清空购物车
     *
     * @return 删除是否成功
     */
    @DeleteMapping("clean")
    public R<String> deleteById() {
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
        shoppingCartService.remove(queryWrapper);
        return R.success("成功清空购物车！");
    }

    /**
     * 分页查询
     *
     * @param shoppingCart 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ShoppingCart>> queryByPage(ShoppingCart shoppingCart, PageRequest pageRequest) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ShoppingCart> queryById(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param shoppingCart 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ShoppingCart> edit(@RequestBody ShoppingCart shoppingCart) {
        return null;
    }

}

