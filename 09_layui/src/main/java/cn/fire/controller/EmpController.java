package cn.fire.controller;

import cn.fire.entity.Emp;
import cn.fire.entity.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author:zl
 * @Date:2020/12/26 08:49:04
 * @Userful:
 */
@RestController
@RequestMapping("emp")
public class EmpController {

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public Map<String, Object> queryEmpList(Page page, @RequestParam String token) {
        Map<String, Object> result = new HashMap<>();

        System.out.println("page:" + page.getPage() + "--limit:" + page.getLimit() + "--token:" + token);



        List<Emp> newList = new ArrayList();
        //再次创建多份数据
        for (int i = 0; i <100 ; i++) {
            Emp emp1 = new Emp();
            emp1.setEmpId(i);
            emp1.setEmpName("张飞"+i);
            emp1.setJob("职位"+i);
            emp1.setSal(4000.0+i);
            emp1.setDeptName("部门"+i);
            newList.add(emp1);
        }


        result.put("data", newList);
        result.put("count", newList.size());
        result.put("code", 200);
        result.put("msg", "success");
        return result;

    }


}
