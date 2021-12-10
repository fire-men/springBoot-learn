package cn.fire.async.controller;

import cn.fire.async.service.IUserService;
import cn.fire.async.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * @Author zhangle
 * @CreateTime 2021-10-21 09:41:59
 * @Description
 */
@Controller

public class AsyncController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @PutMapping("/add/{username}")
    public String addUser(@PathVariable String username){
        System.out.println("=================111");
        String result = "";
        if (username==null || "".equals(username)) {
            result =  "username不能为空!!!";
        }else {
            Boolean flag = userService.addUser(username); //flag = null
//            if (!flag) {
//                result = "添加用户失败了";
//            }else {
//                result = "添加用户成功";
//            }
            result = "添加用户成功";
        }
        System.out.println("=================222");
        return result;
    }

    @RequestMapping("/{name}")
    @ResponseBody
    public Result love(@PathVariable  String name){
        System.out.println("---------------------------");
        if ("".equals(name) ) {
            return Result.error("你输入的名字不能为空");
        }else if(!"刘晓静".equals(name)){
            return Result.error("您的名字必须为刘晓静，否则休想进入！！！");
        }else {
            return Result.success("想你了，媳妇，爱你的乐乐.......",null);
        }

    }

    //获取随机数
    @RequestMapping("/random")
    @ResponseBody
    public Result getRandomNum(HttpServletRequest request){


        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append("亲爱的，你选的随机三位数为>> ");
        for (int i = 0; i <3 ; i++) {
            int i1 = rd.nextInt(10);
            sb.append(i1+" ");
        }
        System.out.println(sb);
        return Result.success("幸运数字",sb);

    }

}
