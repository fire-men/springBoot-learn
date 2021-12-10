package com.example.security.mapper;

import com.example.security.domain.Operate;
import com.example.security.domain.Role;
import com.example.security.domain.User;

import java.util.List;

public interface UserMapper {

    void insertUser(User user);

    User queryUserByUserName(String userName);

    List<Role> queryRolesByUid(Integer uid);

    List<Operate> getOperateList(Integer userId);
}