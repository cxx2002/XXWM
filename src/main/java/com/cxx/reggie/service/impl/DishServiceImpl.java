package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.dto.DishDto;
import com.cxx.reggie.mapper.DishMapper;
import com.cxx.reggie.pojo.Dish;
import com.cxx.reggie.pojo.DishFlavor;
import com.cxx.reggie.service.DishFlavorService;
import com.cxx.reggie.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈喜喜
 * @description 针对表【dish(菜品管理)】的数据库操作Service实现
 * @createDate 2022-08-21 20:58:20
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
        implements DishService {
    @Resource
    private DishFlavorService dishFlavorService;
    @Resource
    private DishMapper dishMapper;

    //新增菜品，同时保存对应的口味数据
    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);
        //插入数据库之前，会自动雪花算法生成id
        Long dishId = dishDto.getId();
        //给口味list的每个元素都加上菜品id
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().
                map
                        ((item) -> {
                            item.setDishId(dishId);
                            return item;
                        }).collect(Collectors.toList());

        //保存菜品口味数据到我们的菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * //根据id查询菜品信息和对应的口味信息，修改页面的回显功能
     *
     * @param id 主键
     * @return DishDto
     */
    @Override
    @Transactional
    public DishDto getByIdWithFlavor(Long id) {
        Dish dish = super.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavorsList = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavorsList);
        return dishDto;
    }

    @Override
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
        //更新dish表的信息
        super.updateById(dishDto);
        //先删除该菜品对应的所有口味信息
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(queryWrapper);
        //再新增该菜品带修改的前端传过来的口味信息
        List<DishFlavor> flavorsList = dishDto.getFlavors();
        flavorsList.stream().map(item -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavorsList);
    }

    @Override
    public void updateStatusById(Integer status, Long id) {
        dishMapper.updateStatusById(status, id);
    }

}




