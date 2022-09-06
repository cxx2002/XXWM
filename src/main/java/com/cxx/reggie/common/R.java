package com.cxx.reggie.common;

/**
 * @author 陈喜喜
 * @date 2022-08-18 16:23
 */

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 3973685263588394253L;

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> res = new R<T>();
        res.data = object;
        res.code = 1;
        return res;
    }


    public static <T> R<T> error(String msg) {
        R res = new R();
        res.msg = msg;
        res.code = 0;
        return res;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }



}


