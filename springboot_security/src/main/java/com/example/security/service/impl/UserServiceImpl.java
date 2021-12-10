package com.example.security.service.impl;

import com.example.security.domain.Operate;
import com.example.security.domain.Role;
import com.example.security.domain.User;
import com.example.security.mapper.UserMapper;
import com.example.security.service.UserService;
import com.example.security.util.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:19:50
 * @Description
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.queryUserByUserName(userName);
        if (user == null) {
            throw new UserException("用户为空");
        }
        //查询用户角色列表
        List<Role> roles = userMapper.queryRolesByUid(user.getId());
        user.setRoles(roles);
        //保存到redis中
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(User.class));
        BoundHashOperations<String, Object, User> hashOps = redisTemplate.boundHashOps("redis:user");
        hashOps.put(String.valueOf(user.getId()),user);
        hashOps.expire(30,TimeUnit.MINUTES);
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public boolean hasAuthority(String authority) {
        //查询当前用户所有权限是否包含
//
//        BoundHashOperations<String, Object, User> hashOps = redisTemplate.boundHashOps("redis:user");
//        User user = hashOps.get("1");
        //写死，没有从redis中获取
        List<Operate> operates = userMapper.getOperateList(1);
       // List<Operate> operates = userMapper.getOperateList(2);
        System.out.println(operates);
        //刷选
        long count = operates.stream().filter(operate -> operate.getOperateRange().equals(Integer.valueOf(authority))).count();
        System.out.println("count="+count);
        if (count >= 1) {
            return true;
        }
        return false;

    }
}
