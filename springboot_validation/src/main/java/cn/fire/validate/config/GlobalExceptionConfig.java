package cn.fire.validate.config;

import cn.fire.validate.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 16:55:31
 * @Description 全局异常处理器
 */
//@ControllerAdvice(basePackages = "cn.fire.validate.api") 必须要与Api目录下的类上使用的注解相对应
@RestControllerAdvice(basePackages = "cn.fire.validate.api")
@Slf4j
public class GlobalExceptionConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Exception.class})
    public Result backErrorInfoForUser(Throwable th) {
        log.error("捕获的异常信息为：{}", th.getMessage());
        return Result.error(th.getMessage());
    }
}
