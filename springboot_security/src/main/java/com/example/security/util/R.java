package com.example.security.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:22:05
 * @Description
 */
@Data
@AllArgsConstructor
public class R<T> {
    private String code;
    private String message;
    private T data;

    private R(){}

    public static R success(String message,Object data){
        return new R("200",message,data);
    }

    public static R fail(String code,String message,Object data){
        return new R(code,message,data);
    }

}
