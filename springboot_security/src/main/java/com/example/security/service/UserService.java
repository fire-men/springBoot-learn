package com.example.security.service;

import com.example.security.domain.User;
import org.springframework.security.access.expression.SecurityExpressionOperations;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:19:29
 * @Description
 */
public interface UserService  {
    void addUser(User user);

    boolean hasAuthority(String authority);




}
