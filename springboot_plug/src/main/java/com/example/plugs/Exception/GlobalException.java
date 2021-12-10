package com.example.plugs.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.jws.HandlerChain;

/**
 * @Author zhangle
 * @CreateTime 2021-11-26 15:52:22
 * @Description
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public void dealException(Exception ex) {
       log.error("error info is {}",ex.getMessage());
    }
}
