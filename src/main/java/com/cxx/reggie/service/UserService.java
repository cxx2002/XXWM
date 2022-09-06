package com.cxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxx.reggie.pojo.User;

/**
 * @author 陈喜喜
 * @description 针对表【user(用户信息)】的数据库操作Service
 * @createDate 2022-08-31 17:12:27
 */
public interface UserService extends IService<User> {

    void sendMsg(String phone, String subject, String context);
}
