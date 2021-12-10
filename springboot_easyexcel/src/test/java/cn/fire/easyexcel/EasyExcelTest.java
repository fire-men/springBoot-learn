package cn.fire.easyexcel;

import cn.fire.easyexcel.domain.User;
import cn.fire.easyexcel.listener.ExcelReadListener;
import cn.fire.easyexcel.service.ExcelService;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasyExcelTest {

    @Resource
    private ExcelService excelService;

    @Test
    void readByFilePath() {
        String filepath = "C:\\Users\\zhangle\\Desktop\\学生信息.xlsx";
        List<User> list = excelService.read(filepath);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    void readByFilePath2() {
        String filepath = "C:\\Users\\zhangle\\Desktop\\学生信息.xlsx";
        excelService.read(filepath,User.class,new ExcelReadListener());
    }


    @Test
    void readByFilePath3() {
        String filepath = "C:\\Users\\zhangle\\Desktop\\学生信息.xlsx";
        List<User> users = excelService.readAndBack(filepath, User.class, new ExcelReadListener());
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    @Test
    void simpleWriteTest(){
        String filepath = "C:\\Users\\zhangle\\Desktop\\学生信息2.xlsx";
        List<User> userList = new ArrayList(){{
            add(new User("马超",25,"河北","15543598429","machao@qq.com"));
            add(new User("刘备",35,"山东","15543598429","liubei@qq.com"));
            add(new User("关羽",25,"天津","15543598429","guanyu@qq.com"));
            add(new User("曹操",55,"北京","15543598429","caocao@qq.com"));
            add(new User("赵云",15,"河南","15543598429","zhaoyun@qq.com"));
            add(new User("张飞",25,"武汉","15543598429","zhangfei@qq.com"));
        }};
        Sheet sheet = new Sheet(1);
        sheet.setSheetName("学生基本详情页");
        excelService.simpleWrite(filepath,User.class,sheet,userList);
    }

    /**
     * 读取文档中共有几个sheet
     */
    @Test
    void getSheetList(){
        ExcelReaderBuilder readerBuilder = new ExcelReaderBuilder();

    }



}
