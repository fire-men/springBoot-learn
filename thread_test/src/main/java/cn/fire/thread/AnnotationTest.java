package cn.fire.thread;

import cn.fire.thread.util.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 13:44:17
 * @Description
 */
public class AnnotationTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<AnnotationTest> class1 = AnnotationTest.class;
        AnnotationTest instance = class1.newInstance();
        Method[] methods = class1.getDeclaredMethods();

        for (int i = 0; i <methods.length ; i++) {
            Method method = methods[i];
            MyTest myTest = method.getDeclaredAnnotation(MyTest.class);
            if (myTest!=null) {
                method.invoke(instance,null);
            }
            continue;
        }
    }

    @MyTest
    void eat(){
        System.out.println("吃............");
    }

    @MyTest
    void run(){
        System.out.println("在奔跑......");
    }

    void fly(){
        System.out.println("fly...........");
    }
}
