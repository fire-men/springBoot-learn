package cn.fire.easyexcel.controller;

import cn.fire.easyexcel.domain.User;
import cn.fire.easyexcel.listener.ExcelReadListener;
import cn.fire.easyexcel.service.ExcelService;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-11-08 16:38:10
 * @Description
 */
@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/")
    private String to_index() {
        return "index";
    }

    /**
     * 上传文件并进行解析
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) {
        List<User> userList = null;
        if (null == file) {
            return JSON.toJSONString("文件不能为空");
        }
        //判断文件是否为excel格式

        //判断文件大小是否符合指定的范围

        Sheet sheet = new Sheet(1);
        sheet.setSheetName("学生基本详情页");
        try {
            userList = excelService.upload(file.getInputStream(), User.class, sheet, new ExcelReadListener());

        } catch (IOException e) {
            return JSON.toJSONString("异常信息为："+e.getMessage());
        }
        return JSON.toJSONString(userList);
    }


    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(HttpServletResponse response){
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=studentList_download.xlsx");
        Sheet sheet = new Sheet(1);
        sheet.setSheetName("学生列表detail_download_1");

        //模拟从DB中获取学生列表信息
        List<User> userList = new ArrayList(){{
            add(new User("马超",25,"河北","15543598429","machao@qq.com"));
            add(new User("刘备",35,"山东","15543598429","liubei@qq.com"));
            add(new User("关羽",25,"天津","15543598429","guanyu@qq.com"));
            add(new User("曹操",55,"北京","15543598429","caocao@qq.com"));
            add(new User("赵云",15,"河南","15543598429","zhaoyun@qq.com"));
            add(new User("张飞",25,"武汉","15543598429","zhangfei@qq.com"));
        }};
        try {
            excelService.download(response.getOutputStream(),User.class,sheet,userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
