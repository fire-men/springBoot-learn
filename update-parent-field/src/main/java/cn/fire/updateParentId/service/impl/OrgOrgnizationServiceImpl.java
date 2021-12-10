package cn.fire.updateParentId.service.impl;

import cn.fire.updateParentId.dao.OrgOrgnizationDao;
import cn.fire.updateParentId.domain.*;
import cn.fire.updateParentId.service.OrgOrgnizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-09 10:27:19
 * @Description
 */
@Service
@Slf4j
public class OrgOrgnizationServiceImpl  implements OrgOrgnizationService {
    @Autowired
    private OrgOrgnizationDao orgnizationDao;

     List<OrgOrganization> queryAll = new ArrayList<>();



    public void updateParentId() {

        try {
            //自关联查询所有keyid -> parentId 对应关系
            List<OrgOrganization> orgOrganizationList = orgnizationDao.selectAllKeyIdAndParentId1();

            //根据keyid更新parentid,待优化>>>>
            //TODO
            if (orgOrganizationList != null && orgOrganizationList.size() > 0) {
                for (int i = 0; i < orgOrganizationList.size(); i++) {
                    orgnizationDao.updateParentIdByKeyId(orgOrganizationList.get(i));
                }
            }
            log.info("子关联更新成功>>>>>>>");
        } catch (Exception e) {
            log.error("子关联更新失败,失败信息：{}", e.getMessage());
        }

    }

    public void updateParentI3() {

        try {
            //自关联查询所有keyid -> parentId 对应关系
            List<OrgOrganization> orgOrganizationList = orgnizationDao.selectAllKeyIdAndParentId1();
          //  List<String> ids = new ArrayList<>();
            List<String> eccodes = new ArrayList<>();
            List<String> erps = new ArrayList<>();
            List<String> vehicles = new ArrayList<>();
//            for (int i = 0; i < orgOrganizationList.size(); i++) {
//                String keyid = orgOrganizationList.get(i).getKeyid();
//                ids.add(keyid);
//            }

            for (int i = 0; i < orgOrganizationList.size(); i++) {
                String orgaCode = orgOrganizationList.get(i).getECC_Orga_Code();
                eccodes.add(orgaCode);
            }

//            for (int i = 0; i < orgOrganizationList.size(); i++) {
//                String erpOrgaCode = orgOrganizationList.get(i).getERP_Orga_Code();
//                erps.add(erpOrgaCode);
//            }

//            for (int i = 0; i < orgOrganizationList.size(); i++) {
//                String vehicleOrgaCode = orgOrganizationList.get(i).getVehicle_Orga_Code();
//                vehicles.add(vehicleOrgaCode);
//            }
            //根据keyid更新parentid,待优化>>>>
            orgnizationDao.batchUpdateParentId2(orgOrganizationList,eccodes);
            log.info("子关联更新成功>>>>>>>");
        } catch (Exception e) {
            log.error("子关联更新失败,失败信息：{}", e.getMessage());
        }

    }


    @Override
    public void batchInsert(List<OrgOrganization> orgOrganizations) {

        orgnizationDao.batchInsertOrgOrganizations(orgOrganizations);
    }

    /**
     * 批量更新
     * INSERT INTO … ON DUPLICATE KEY UPDATE 测试
     */
    @Override
    public void batchUpdateParentId(List<OrgOrganization> organizations) {
        //参数校验

        orgnizationDao.batchUpdateParentId(organizations);
    }


    @Transactional
    public void batchUpdateParentId2() {
//
//        try {
//            //自关联查询所有keyid -> parentId 对应关系
//            List<OrgOrganization> orgOrganizationList = orgnizationDao.selectAllKeyIdAndParentId();
//
//            if (orgOrganizationList != null && orgOrganizationList.size() > 0) {
//                orgnizationDao.batchUpdateParentId2(orgOrganizationList);
//            }
//            log.info("子关联更新成功>>>>>>>");
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("子关联更新失败,失败信息：{}", e.getMessage());
//        }

        //每次获取的数量
        int pageSize = 10000;
        //查询总数据量
        int total = orgnizationDao.selectTotalNum();
        //获取页数
        int page = total % pageSize == 0 ? (total / pageSize) : ((total / pageSize) + 1);
        //获取所有data
        queryAll = queryAll();
        //多线程处理批量操作
        try {
            for (int i = 1; i <= page; i++) {
                log.info("第" + (i) + "个线程开始执行>>>>>>>>>>>>>>>>>>>>");
                int finalI = i;
                new Thread(() -> {

                        int skipNum = (finalI - 1) * pageSize;
                        //分页查询数据
                        //List<OrgOrganization> organizations = orgnizationDao.selectOrganizationsByLimit(skipNum, pageSize);
                        List<OrgOrganization> organizations = queryAllByLimit(skipNum, pageSize, queryAll);

                        //更新数据
                        if (organizations != null && organizations.size() > 0) {
                            for (int j = 0; j < organizations.size(); j++) {
                                orgnizationDao.updateById(organizations.get(j));
                            }
                        }



                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  List<OrgOrganization> queryAllByLimit(final int skipNum,final int pageSize, final List<OrgOrganization> organizations) {
        //参数校验

        List<OrgOrganization> organizationsByPage = new ArrayList<>();
        //对集合做分页处理
        for (int i = skipNum; i < (skipNum + pageSize); i++) {
            //集合判断
            OrgOrganization orgOrganization = organizations.get(i);
            organizationsByPage.add(orgOrganization);
        }
        return organizationsByPage;

    }

    public List<OrgOrganization> queryAll() {
        return orgnizationDao.selectAllKeyIdAndParentId1();
    }


    @Override
    public void updateById(OrgOrganization organization) {
        orgnizationDao.updateById(organization);
    }
}
