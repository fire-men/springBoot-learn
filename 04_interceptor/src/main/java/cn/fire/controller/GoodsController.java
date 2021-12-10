package cn.fire.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zl
 * @Date:2020/12/22 06:56:18
 * @Userful:
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @RequestMapping(value = "/buy", method = RequestMethod.GET, produces = "application/json")
    public String buyGoods() {
        return "购买成功";
    }
}
