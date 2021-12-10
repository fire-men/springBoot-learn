package cn.fire.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.ImageBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.util.Arrays;

//@SpringBootApplication  = @EnableAutoConfiguration +  @Component
@EnableAutoConfiguration
@Component
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//        System.out.println("----------------------");
        SpringApplication application = new SpringApplication(Application.class);
        //不使用Banner文件
        // application.setBannerMode(Banner.Mode.OFF);
        application.setBanner(new ImageBanner(new ClassPathResource("/banner/dog.jpg")));
        //启动Spring应用
        application.run(args);

//        String str = "{\"name\": \"zs\",\"age\": 20}";
//        String xmlStr = "<root>\n" +
//                "    <request>\n" +
//                "<student>zhang</student>\n" +
//                "        " +
//                "</request>\n" +
//                "        " +
//                "</root>";

        /*
        * 经典传奇
        *   account  10844489@qq
        *   password zl4836001
        *
         * */

       
    }

}
