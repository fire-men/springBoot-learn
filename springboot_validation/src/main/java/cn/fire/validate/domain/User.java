package cn.fire.validate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 16:32:35
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    //@NotEmpty(message = "用户名称不能为空")
    private String username;
    private String password;
    private String iphone;
    @Email(message = "您输入的邮箱不符合正常的邮箱格式!!!")
    private String email;
    @Max(value = 120, message = "您输入的年龄超过了人类的极限年龄!!!")
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;
}
