package cn.fire.aop.service;

import cn.fire.aop.domain.User;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 14:22:30
 * @Description
 */
public interface Userservice {
    /**
     * 查询用户信息
     * @return
     */
    User queryUser();
}
