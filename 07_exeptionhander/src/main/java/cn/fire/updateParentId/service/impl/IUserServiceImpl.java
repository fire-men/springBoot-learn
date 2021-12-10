package cn.fire.updateParentId.service.impl;

import cn.fire.exception.UserException;
import cn.fire.updateParentId.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author:zl
 * @Date:2020/12/22 08:13:08
 * @Userful:
 */
@Service("userServiceImpl")
public class IUserServiceImpl implements IUserService {
    @Override
    public void addUser(String username) {
        System.out.println("准备添加学生");
        throw new UserException("添加学生失败");

    }
}
