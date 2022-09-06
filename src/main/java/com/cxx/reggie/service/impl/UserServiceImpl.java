package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.mapper.UserMapper;
import com.cxx.reggie.pojo.User;
import com.cxx.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 陈喜喜
 * @description 针对表【user(用户信息)】的数据库操作Service实现
 * @createDate 2022-08-31 17:12:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public void sendMsg(String phone, String subject, String context) {
        
    }
}




