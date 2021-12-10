package com.example.plugs.Service.impl;

import com.example.plugs.Service.UserService;
import com.example.plugs.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author zhangle
 * @CreateTime 2021-11-26 11:40:15
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User queryUser() {
       return initUser();
    }

    public User initUser(){
        User user = new User();
        user.setUsername("zs").setPassword("123456");
        return user;
    }
}
