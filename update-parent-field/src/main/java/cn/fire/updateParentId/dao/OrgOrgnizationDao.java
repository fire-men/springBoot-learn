package cn.fire.updateParentId.dao;

import cn.fire.updateParentId.domain.OrgOrganization;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-09 10:25:13
 * @Description
 */
//@Repository
public interface OrgOrgnizationDao  {
    List<OrgOrganization> selectAllKeyIdAndParentId1();

    void updateParentIdByKeyId(OrgOrganization orgOrganization);

    void batchInsertOrgOrganizations(List<OrgOrganization> orgOrganizations);

    void batchUpdateParentId(List<OrgOrganization> organizationList);

    void updateById(OrgOrganization organization);

    void batchUpdateParentId2(List<OrgOrganization> orgOrganizationList,List<String> ids);

    int selectTotalNum();

    List<OrgOrganization> selectOrganizationsByLimit(int skipNum, int pageSize);
}
