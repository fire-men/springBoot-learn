package com.example.plugs.pojo;

import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author zhangle
 * @CreateTime 2021-11-26 11:32:17
 * @Description
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class User  {

    private String username;
    private String password;
    @Builder.Default
    private Boolean delFlag = false;
    //@NonNull
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 运行时异常
     * @param uid
     */
    @SneakyThrows
    public void enterRoom(String uid) {
        log.info("permit {} enter...........", uid);
        int res = 10/0;
    }

    /**
     * 编译时异常
     */
    @SneakyThrows
    public void sayHello(){
        String aThrows = new String("sneakyThrows".getBytes(), "UTF-8");
    }


    public void sayHello2() throws UnsupportedEncodingException {
        String aThrows = new String("sneakyThrows".getBytes(), "UTF-8");
    }

}
