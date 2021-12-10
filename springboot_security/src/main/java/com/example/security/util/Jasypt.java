package com.example.security.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:53:58
 * @Description
 */
public class Jasypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //salt
        textEncryptor.setPassword("springboot_security");
        //username
        String username = textEncryptor.encrypt("zl");//1SWsO16NEBWAZ0x39O4DRQ==
        //password
        String pwd = textEncryptor.encrypt("zl123");//zzz9lC/zkYjpu3uGZYZkUA==
        System.out.println("username:" + username + "\tpassword:" + pwd);
    }
}
