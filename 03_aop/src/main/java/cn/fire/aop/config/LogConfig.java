package cn.fire.aop.config;

import cn.fire.aop.util.Log;
import cn.fire.aop.util.LogTail;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.SpringBootConfiguration;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:zl
 * @Date:2020/12/21 11:52:38
 * @Userful:
 */
@SpringBootConfiguration
@Aspect
public class LogConfig {

    //   ..表示当前包或者子包
    @Pointcut(value = "execution(* cn.fire.aop..*.s*(..))")
    public void log() {
    }


    @Pointcut(value = "@annotation(cn.fire.aop.util.Log)")
    public void logAnnotation() {
    }

    @Around(value = "logAnnotation()")
    public Object logAnnotationAround(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();
        Date startTime = new Date();
        Log log = signature.getMethod().getAnnotation(Log.class);
        String operate = log.action();
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Date endTime = new Date();

        //记录数据库
        LogTail logTail = new LogTail();
        logTail.setOperator(operate);
        logTail.setMethodName(methodName);
        if(result == null){
            logTail.setResult("该方法没有返回值");
        }else {
            logTail.setResult(result);
        }
        logTail.setUsername("张三");
        logTail.setStartTime(startTime);
        logTail.setEndTime(endTime);
        System.out.println(logTail);

        return result;



    }

    @Around(value = "log()")
    public Object logAround(ProceedingJoinPoint pjp) {
        System.out.println("当前日期为" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Object result = null;
        try {
            result = pjp.proceed();
            System.out.println("执行后的结果为" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("当前日期为" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return result;
    }

}
