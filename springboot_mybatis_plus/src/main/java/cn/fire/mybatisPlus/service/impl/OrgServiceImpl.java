package cn.fire.mybatisPlus.service.impl;

import cn.fire.mybatisPlus.entity.Menu;
import cn.fire.mybatisPlus.entity.OrgOrganization;
import cn.fire.mybatisPlus.mapper.MenuMapper;
import cn.fire.mybatisPlus.mapper.OrgMapper;
import cn.fire.mybatisPlus.service.IMenuService;
import cn.fire.mybatisPlus.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 13:05:57
 * @Description
 */

@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, OrgOrganization> implements IOrgService {

    @Resource
    private OrgMapper orgMapper;

    @Override
    public List<OrgOrganization> selectAllKeyIdAndParentId() {

        return orgMapper.selectAllKeyIdAndParentId();
    }

    @Override
    public void updateParentId() {



    }
}
