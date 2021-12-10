package cn.fire.mybatisPlus.service.impl;

import cn.fire.mybatisPlus.entity.User;
import cn.fire.mybatisPlus.mapper.UserMapper;
import cn.fire.mybatisPlus.service.IUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public Page<User> queryUserListByPage(Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<User>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return  userMapper.selectPage(page,null);
    }
}
