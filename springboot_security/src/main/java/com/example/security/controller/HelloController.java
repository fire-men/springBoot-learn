package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangle
 * @CreateTime 2021-11-25 11:13:25
 * @Description
 */
@RestController
public class HelloController {

    @PreAuthorize("hasRole('user')")
    @GetMapping("/user")
    public String sayHello(){
        return "hello SpringSecurity";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/admin")
    public String sayHello2(){
        return "hello SpringSecurity";
    }

    @PreAuthorize("hasRole('visitor')")
    @GetMapping("/visitor")
    public String sayHello3(){
        return "hello SpringSecurity";
    }

    @PreAuthorize("@userServiceImpl.hasAuthority('0')")
    @GetMapping("/add")
    public String sayHello4(){
        return "hello SpringSecurity";
    }


}
