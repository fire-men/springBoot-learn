package cn.fire.init;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author:zl
 * @Date:2020/12/22 07:40:32
 * @Userful:  @PostConstruct 使用  总用在方法上
 *  用途：项目启动，进行初始化操作
 *  执行时机：在项目启动期间
 */
//@Component
public class PostConstructTest {

    @PostConstruct
    public void init(){
        //模拟向数据库添加数据
        System.out.println("---------数据初始化完成---------");
    }


}
