package com.example.security;

import com.example.security.domain.Operate;
import com.example.security.domain.Role;
import com.example.security.domain.User;
import com.example.security.mapper.UserMapper;
import com.example.security.util.DeleteStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 13:54:20
 * @Description
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUserTest(){
        User user = new User();
        user.setUserName("关羽");
        user.setNickName("马上到来");
        user.setAddress("山东济南");
        user.setEmail("guanyu@qq.com");
        user.setRemark("我很秀123");
        user.setIsDelete(0);
        user.setCreateBy("zs");
        user.setCreateTime(new Date());
        user.setUpdateBy("zs");
        user.setUpdateTime(new Date());
        user.setState(0);
        userMapper.insertUser(user);

        System.out.println("添加成功:"+user);
    }

    @Test
    public void queryRolesByUidTest(){
        List<Role> roles = userMapper.queryRolesByUid(2);
        System.out.println(roles);
    }

    @Test
    public void queryUserByUserNameTest(){
        User user = userMapper.queryUserByUserName("韩信");
        System.out.println(user);
    }

    @Test
    public void queryOperateListByUidTest(){
        List<Operate> operateList = userMapper.getOperateList(1);
        System.out.println(operateList);
    }
}
