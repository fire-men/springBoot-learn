package cn.fire.elasticJob.service.impl;


import cn.fire.elasticJob.entity.Menu;
import cn.fire.elasticJob.mapper.MenuMapper;
import cn.fire.elasticJob.service.IMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuListBySort(Double sort) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sort",30);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public Menu queryById(Integer id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<Menu> queryAll() {
        return menuMapper.selectList(null);
    }
}
