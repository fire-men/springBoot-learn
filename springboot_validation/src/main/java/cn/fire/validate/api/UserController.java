package cn.fire.validate.api;

import cn.fire.validate.domain.User;
import cn.fire.validate.service.IUserService;
import cn.fire.validate.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Author zhangle
 * @CreateTime 2021-10-14 16:37:07
 * @Description
 */
@RestController
@RequestMapping("user")
@Validated
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/add")
    public Result<User> saveUser(@RequestBody(required = false) @Validated User user) {
        return Result.success("添加用户成功", user);
    }


    /**
     * @param user
     * @return
     * @NotNull 作用在对象上失效，只能作用在字段上
     */
    @PostMapping("/add2")
    public Result<User> saveUser2(@RequestBody(required = false) @NotNull User user) {
        return Result.success("添加用户成功", user);
    }

    /**
     * @param username
     * @return
     * @NotEmpty 注解作用在单个字段上全局异常处理配置失效
     * 解决:
     * 在类上添加@Validated注解
     */
    @GetMapping("/query")
    public Result<User> queryUser(@RequestParam(value = "username", required = false) @NotBlank(message = "用户名称不能为空!!!") String username) {
        return Result.success("查询用户成功", new User(username, "", "", "", 20, new Date()));
    }


    /**
     * @param username
     * @return
     * @NotBlank作用在单个字段上，且使用@PathVariable接受，失效 解决：
     * 使用Validation框架 处理单个字段时，不使用@PathVariable接受单个参数，改为@RequestParam
     */
    @GetMapping("/query2/{username}")
    public Result<User> queryUser2(@PathVariable(required = false) @NotBlank(message = "用户名称不能为空!!!") String username) {
        return Result.success("查询用户成功", new User(username, "", "", "", 20, new Date()));
    }


}
