package cn.fire.updateParentId.service;

import cn.fire.updateParentId.domain.OrgOrganization;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-09 10:25:50
 * @Description
 */
public interface OrgOrgnizationService  {
    /**
     * 通过keyid更新parentid
     */
    public void updateParentId();

    /**
     * 批量添加
     * @param orgOrganizations
     */
    public void batchInsert(List<OrgOrganization> orgOrganizations);

    /**
     * 批量更新parentid
     * @param
     */
    public void batchUpdateParentId(List<OrgOrganization> organizations);

    /**
     * 通过id更新
     * @param organization
     */
    void updateById(OrgOrganization organization);

    void batchUpdateParentId2();

    void updateParentI3();
}
