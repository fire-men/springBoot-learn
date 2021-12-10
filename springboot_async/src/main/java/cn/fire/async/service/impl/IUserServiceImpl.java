package cn.fire.async.service.impl;

import cn.fire.async.service.IUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author zhangle
 * @CreateTime 2021-10-21 09:43:20
 * @Description
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Async
    @Override
    public Boolean addUser(String username) {
        System.out.println("username："+username);
        System.out.println("执行添加用户操作.............");
        return true;
    }
}
