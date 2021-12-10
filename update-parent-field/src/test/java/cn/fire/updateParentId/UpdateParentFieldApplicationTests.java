package cn.fire.updateParentId;

import cn.fire.updateParentId.domain.*;
import cn.fire.updateParentId.service.OrgOrgnizationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UpdateParentFieldApplicationTests {

    @Autowired
    private OrgOrgnizationService orgnizationService;

    @Test
    void batchInsert() {

//        orgnizationService.batchInsert(
//                new ArrayList<OrgOrganization>() {{
//                    add(new OrgOrganization("1", "0", "0"));
//                    add(new OrgOrganization("2", "1", "66"));
//                    add(new OrgOrganization("3", "1", "55"));
//                    add(new OrgOrganization("4", "0", "0"));
//                }}
//        );

    }

    @Test
    void updateParentId(){
        orgnizationService.updateParentId();
    }

//    @Test
//    void batchUpdateParentId(){
//        orgnizationService.batchUpdateParentId();
//    }

    @Test
    void batchUpdateParentId2(){
        orgnizationService.batchUpdateParentId2();
    }

//    @Test
//    void updateById(){
//        orgnizationService.updateById(new OrgOrganization("1","","",new Date()));
//    }


    @Test
    void batchUpdateParentId3(){
        long startTime = System.currentTimeMillis();
        orgnizationService.updateParentI3();
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时"+(endTime-startTime)+"ms");

    }
}
