package cn.fire.entity;

import lombok.Data;

/**
 * @Author:zl
 * @Date:2020/12/26 08:52:49
 * @Userful:
 */
@Data
public class Emp {
    private Integer empId;
    private String empName;
    private String job;
    private Double sal;
    private String deptName;
}
