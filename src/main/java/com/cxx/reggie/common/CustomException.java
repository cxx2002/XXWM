package com.cxx.reggie.common;

/**
 * @author 陈喜喜
 * @date 2022-08-21 21:23
 * <p>
 * 自定义业务异常
 */
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 2978830564385096438L;

    public CustomException(String message) {
        super(message);
    }
}
