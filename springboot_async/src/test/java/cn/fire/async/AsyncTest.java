package cn.fire.async;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@SpringBootTest
@Component
class AsyncTest {

    @Async
    void test1() {
        System.out.println("|||||||||||||||||||||");

        System.out.println("***************************");
    }


    /***
     * 同一个类中调用使用@Async的方法，失效
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("11111111111111111111111111");
        new AsyncTest().test1();
        System.out.println("22222222222222222222222222222");

    }

}
