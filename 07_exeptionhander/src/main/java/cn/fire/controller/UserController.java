package cn.fire.controller;

        import cn.fire.updateParentId.service.IUserService;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;

/**
 * @Author:zl
 * @Date:2020/12/22 08:10:59
 * @Userful:
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    IUserService userServiceImpl;

    @RequestMapping("/add/{username}")
    public String addUser(@PathVariable String username){
        userServiceImpl.addUser(username);
        return "添加成功";
    }
}

