package cn.fire.springboot;

import cn.fire.springboot.config.StudentConfig;
import cn.fire.springboot.pojo.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@SpringBootApplication
@RestController
@SpringBootApplication
public class Boot {
//    //读取主配值文件中的属性
//    @Value("${server.port}")
//    String port;
//
//    //读取自定义的配置文件
//    @Autowired
//    StudentConfig studentConfig;
//
//    //    @Qualifier(value = "dataSource3306")
////    @Autowired
//    @Resource(name = "dataSource3306")
//    DataSource dataSource3306;
//
//    //    @Qualifier(value = "dataSource3307")
////    @Autowired
//    @Resource(name = "dataSource3307")
//    DataSource dataSource3307;
//
//    //    @Qualifier(value = "dataSource3308")
////    @Autowired
//    @Resource(name = "dataSource3308")
//    DataSource dataSource3308;
//
//    @RequestMapping("/hello")
//    public String hello() {
//        return "hello boot!" + port + "--" + studentConfig.toString();
//    }
//
//    @RequestMapping("/getDataSource")
//    public List<DataSource> getDataSource() {
//        System.out.println(dataSource3306);
//        System.out.println(dataSource3307);
//        System.out.println(dataSource3308);
//        List<DataSource> dataSources = Arrays.asList(
//                dataSource3306,
//                dataSource3307,
//                dataSource3308
//        );
//
//        return dataSources;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);

    }

}
