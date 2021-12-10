package cn.fire.updateParentId.controller;

import cn.fire.updateParentId.service.OrgOrgnizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 14:32:15
 * @Description
 */
@RestController
public class OrgController {
    @Autowired
    private OrgOrgnizationService orgOrgnizationService;

    @PutMapping("/updateParentId")
    public String update(){
        orgOrgnizationService.updateParentI3();
        return "更新成功";
    }
}
