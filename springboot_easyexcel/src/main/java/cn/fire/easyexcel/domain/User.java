package cn.fire.easyexcel.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author zhangle
 * @CreateTime 2021-11-08 14:44:11
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    //excel表头的内容信息，必须要与该实体类的字段信息一致
    @ExcelProperty("姓名")
    private String userName;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("地址")
    private String address;
    @ExcelProperty("手机号码")
    private String iphone;
    @ExcelProperty("电子邮箱")
    private String email;
}
