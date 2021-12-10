package cn.fire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:zl
 * @Date:2020/12/22 06:41:59
 * @Userful:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String nick;
    private String loginAccount;
    private String loginPassword;
    private String email;

}
