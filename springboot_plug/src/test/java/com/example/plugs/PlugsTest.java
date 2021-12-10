package com.example.plugs;

import com.example.plugs.Service.UserService;
import com.example.plugs.pojo.Role;
import com.example.plugs.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-11-26 11:31:34
 * @Description
 */
@SpringBootTest
public class PlugsTest {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    public void aixcoderTest(){
        User user = new User();
        user.setUsername("zs").setPassword("123456");
        System.out.println(user);

    }

    @Test
    public void sequenceTest(){
        System.out.println(userService.queryUser());
    }

    @Test
    public void lombokBuilderTest(){
        User user = User.builder()
                        .username("张三丰")
                        .password("123")
                        .createTime(new Date())
                        .build();
        System.out.println(user);


    }


    
    public void lombokSneakThrowTest(){
        User user = User.builder().build();
     //   user.enterRoom("1111");
        user.sayHello();
    }
}
