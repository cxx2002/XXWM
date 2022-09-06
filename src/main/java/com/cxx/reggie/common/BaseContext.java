package com.cxx.reggie.common;

/**
 * @author 陈喜喜
 * @date 2022-08-21 10:37
 * <p>
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static void setCurrentId(Long id) {
        BaseContext.threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return BaseContext.threadLocal.get();
    }
}
