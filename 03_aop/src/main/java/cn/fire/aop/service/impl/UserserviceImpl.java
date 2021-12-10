package cn.fire.aop.service.impl;

import cn.fire.aop.domain.User;
import cn.fire.aop.service.Userservice;
import cn.fire.aop.util.Log;
import org.springframework.stereotype.Service;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 14:22:40
 * @Description
 */
@Service
public class UserserviceImpl implements Userservice {

    @Override
    public User queryUser() {
        return new User("张三","123456");
    }
}
