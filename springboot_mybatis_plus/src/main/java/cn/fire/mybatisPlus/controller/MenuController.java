package cn.fire.mybatisPlus.controller;


import cn.fire.mybatisPlus.entity.Menu;
import cn.fire.mybatisPlus.service.IMenuService;
import cn.fire.mybatisPlus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    /**
     * 条件构造器使用
     * @param sort
     * @return
     */
    @ResponseBody
    @GetMapping("/query/{sort}")
    public Result queryMenuListByCondition(@PathVariable Double sort) {
        List<Menu> menus = null;
        if (sort != null && sort != 0) {
            menus = menuService.selectMenuListBySort(sort);

        }
        return Result.success("查询成功", menus);
    }

    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public Result deleteMenuInfoById(@PathVariable Integer id){
        try {
            boolean flag = menuService.removeById(id);

        } catch (Exception e) {
            e.printStackTrace();
            Result.error("删除失败");
        }

        return Result.success("删除成功",null);
    }

    @ResponseBody
    @PutMapping("/update/{id}")
    public Result updateMenuInfoById(@PathVariable Integer id){
        Menu menu = new Menu();
        menu.setId(41L);
        menu.setSort(new BigDecimal(30));
        try {
//            Menu menu1 = menuService.queryById(id);
//            //获取当前版本号
//            Integer version = menu1.getVersion();

            menuService.updateById(menu);
        } catch (Exception e) {
            e.printStackTrace();
            Result.error("更新失败");
        }
       return Result.success("更新成功",menu);

    }
}
