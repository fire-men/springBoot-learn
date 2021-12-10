package com.example.security.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:25:57
 * @Description
 */

@AllArgsConstructor
public enum UserStateEnum {
    Normal(0, "正常"),
    Unavailiable(1, "失效"),
    Lock(2, "账号被锁定");

    private Integer code;
    private String message;

    /**
     * 通过code获取对应内容
     *
     * @param code
     * @return
     */
    public static String getContextByCode(Integer code) {
        UserStateEnum[] values = UserStateEnum.values();
        for (UserStateEnum value : values) {
            if (value.code.equals(code)) {
                return value.message;
            }
            continue;
        }
        return null;
    }


}
