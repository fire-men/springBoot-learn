package cn.fire.mybatisPlus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 10:41:35
 * @Description
 */
@MapperScan(basePackages = "cn.fire.mybatisPlus.mapper")
@SpringBootApplication
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
