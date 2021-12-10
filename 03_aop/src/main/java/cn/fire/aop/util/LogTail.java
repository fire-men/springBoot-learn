package cn.fire.aop.util;

import lombok.Data;

import java.util.Date;

/**
 * @Author:zl
 * @Date:2020/12/21 12:47:32
 * @Userful: 封装日志的一些属性
 */
@Data
public class LogTail {
    private String operator;
    private String methodName;
    private Object result;
    private String username;
    private Date startTime;
    private Date endTime;


}
