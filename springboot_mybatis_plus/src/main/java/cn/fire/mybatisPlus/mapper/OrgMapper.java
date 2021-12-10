package cn.fire.mybatisPlus.mapper;

import cn.fire.mybatisPlus.entity.OrgOrganization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 13:02:14
 * @Description
 */
public interface OrgMapper extends BaseMapper<OrgOrganization> {
   List<OrgOrganization> selectAllKeyIdAndParentId();
}
