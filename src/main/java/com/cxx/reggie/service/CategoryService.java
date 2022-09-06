package com.cxx.reggie.service;

import com.cxx.reggie.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 陈喜喜
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-08-21 11:01:52
*/
public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
