package com.cxx.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 陈喜喜
 * @date 2022-08-20 21:55
 * // 自定义元数据对象处理器，自动填充
 * // 发送一次Http请求，服务端就会新创建一个线程来处理来处理该请求，即处理请求用到的所有方法使用同一个线程
 * //   可以通过ThreadLocal来获取 处理该http请求的线程的唯一标识 线程id
 * 1、LoginCheckFilter的doFilter方法（拦截器）
 * 2、EmployeeController的update方法
 * 3、MyMetaObjectHandler的updateFill方法
 * 这个三个方法共享一个线程
 * 什么是ThreadLocal?
 * ThreadLocal并不是一个Thread,而是Thread的局部变量。当使用ThreadLocal维护变量时, ThreadLocal为每个使用该
 * 变量的线程提供独立的变量副本,所以每-一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
 * ThreadLocal为每个线程提供单独一份存储空间，具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问。
 * ThreadLocal常用方法:
 * public void set(T value)设 置当前线程的线程局部变量的值
 * public T get()
 * 返回当前线程所对应的线程局部变量的值
 * 我们可以在LoginCheckFilter的doFilter方法中获取当前登录用户id,并调用ThreadLocal的set方 法来设置当前线程的线
 * 程局部变量的值(用户id) ， 然后在MyMetaObjectHandler的updateFill方 法中调用ThreadLocal的get方法来获得当前
 * 线程所对应的线程局部变量的值(用户id) 。
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        MyMetaObjectHandler.log.info("公共字段自动填充[insert]....");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        MyMetaObjectHandler.log.info("公共字段自动填充[update]....");
        MyMetaObjectHandler.log.info(metaObject.toString());
        long id = Thread.currentThread().getId();
        MyMetaObjectHandler.log.info("update自动填充线程id为{}", id);
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}

