package com.example.security.util;

import lombok.AllArgsConstructor;
import org.omg.CORBA.INTERNAL;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:41:30
 * @Description
 */
@AllArgsConstructor
public enum DeleteStateEnum {

    NoDelete(0,"未删除"),HaveDeleted(1,"已删除");
    private Integer code;
    private String message;

    /**
     * 通过code获取对应内容
     *
     * @param code
     * @return
     */
    public static String getContextByCode(Integer code) {
        DeleteStateEnum[] values = DeleteStateEnum.values();
        for (DeleteStateEnum value : values) {
            if (value.code.equals(code)) {
                return value.message;
            }
            continue;
        }
        return null;
    }

}
