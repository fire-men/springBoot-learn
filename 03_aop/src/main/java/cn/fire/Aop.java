package cn.fire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot中使用AOP
 *
 * Spring中AOP默认是基于JDK动态代理实现的
 * SpringBoot中AOP默认是基于Cglib代理实现的
 */

@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)//开启AspectJ配置
@SpringBootApplication
public class Aop {

    public static void main(String[] args) {
        SpringApplication.run(Aop.class, args);
    }

}
