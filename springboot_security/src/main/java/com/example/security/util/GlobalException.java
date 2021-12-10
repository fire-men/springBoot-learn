package com.example.security.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 15:41:02
 * @Description
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public R backInfo(Exception ex){
       return R.fail("444",ex.getMessage(),null);
    }

}
