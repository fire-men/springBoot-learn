package cn.fire.updateParentId.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-10-11 16:26:57
 * @Description
 */
@Data
public class Menu implements Serializable {
    private Integer id;
    private String menuName;
    private Integer parentId;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
    private Integer isDelete;

}
