package cn.fire.mybatisPlus.controller;


import cn.fire.mybatisPlus.entity.User;
import cn.fire.mybatisPlus.service.IUserService;
import cn.fire.mybatisPlus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping("/queryAll")
    public Result queryAll(){
        return Result.success("查询用户列表成功",userService.queryUserList());
    }

    @ResponseBody
    @GetMapping("/queryAllByPage/{pageNum}/{pageSize}")
    public Result queryAllByPage(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return Result.success("查询用户列表成功",userService.queryUserListByPage(pageNum,pageSize).getRecords());
    }
}
