package cn.fire;

import cn.fire.aop.service.IHelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private IHelloService helloService;

    @Test
    void logTest() {
        helloService.insertStudentInfo();
    }


    @Test
    void logTest2() {
        helloService.batchInsertStudentInfo();
    }

    @Test
    void logTest3() {
        helloService.batchInsertStudentInfo2();
    }

    @Test
    void annationTest(){
      String str = "@user.queryUser()";
        System.out.println(str);
    }


}
