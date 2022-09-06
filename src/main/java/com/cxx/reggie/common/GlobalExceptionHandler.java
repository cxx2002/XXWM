package com.cxx.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author 陈喜喜
 * @date 2022-08-19 21:44
 *
 * 全局异常处理
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    //添加数据，主键唯一发生冲突的sql异常
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandle(SQLIntegrityConstraintViolationException ex){
        log.info(ex.getMessage());
        if(ex.getMessage().contains("Duplicate entry")){
            String[] msg = ex.getMessage().split(" ");
            return R.error("创建失败！"+msg[2]+"已存在!");
        }
        return R.error("创建失败！"+ex.getMessage());
    }
    //删除数据，逻辑外键有关联发生的自定义的业务异常
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandle(CustomException ex){
        log.info(ex.getMessage());
        return R.error(ex.getMessage());
    }
}
