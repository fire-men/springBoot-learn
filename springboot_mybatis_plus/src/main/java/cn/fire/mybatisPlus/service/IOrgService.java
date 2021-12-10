package cn.fire.mybatisPlus.service;

import cn.fire.mybatisPlus.entity.OrgOrganization;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 13:04:15
 * @Description
 */
public interface IOrgService extends IService<OrgOrganization> {

    List<OrgOrganization> selectAllKeyIdAndParentId();

    void updateParentId();
}
