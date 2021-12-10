package com.example.security;

import com.example.security.util.UserStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:45:06
 * @Description
 */
@SpringBootTest
public class EnumTest {

    @Test
    public void userStateEnumTest(){
        String message = UserStateEnum.getContextByCode(3);
        System.out.println(message);
        if (null == message) {
            throw new RuntimeException("您输入的code值不存在!!!");
        }

    }
}
