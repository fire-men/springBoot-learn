package cn.fire.aop.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:zl
 * @Date:2020/12/21 12:32:45
 * @Userful:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
    /* 描述该方法的行为 */
    String action();
}
