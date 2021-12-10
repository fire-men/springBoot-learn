package cn.fire.aop.controller;

import cn.fire.aop.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:zl
 * @Date:2020/12/21 12:00:06
 * @Userful:
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    IHelloService helloService;

    @RequestMapping(value = "/aop/{username}", method = RequestMethod.GET,produces = "application/json")
    public String aop(@PathVariable String username) {
        String result = helloService.say(username);
       // System.out.println(helloService);
        return result;
    }

    //测试日志注解
    @RequestMapping(value = "aop2/{username}",method = RequestMethod.GET,produces = "application/json")
    public String logAnnotaion(@PathVariable String username){
        try {
            helloService.insertStudentInfo();
           // System.out.println(helloService);
            return "添加成功";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "添加失败，错误信息为"+e.getMessage();
        }

    }

}
