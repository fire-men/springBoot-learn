package cn.fire.mybatisPlus.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-10-09 10:21:46
 * @Description 主数据-机构-组织机构
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrgOrganization {
    private String keyid;
    private String parentid;
    private String ECC_Orga_Code;
    private Date modifyTime;

}
