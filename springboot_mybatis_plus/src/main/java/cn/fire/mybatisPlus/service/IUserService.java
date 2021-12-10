package cn.fire.mybatisPlus.service;

import cn.fire.mybatisPlus.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
public interface IUserService extends IService<User> {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> queryUserList();

    Page<User> queryUserListByPage(Integer pageNum, Integer pageSize);
}
