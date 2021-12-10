package cn.fire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:zl
 * @Date:2020/12/26 08:51:35
 * @Userful:
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/emp")
    public String toEmp(){
        return "employee";
    }
}
