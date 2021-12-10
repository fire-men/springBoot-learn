package cn.fire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"cn.fire.updateParentId.dao"})
@SpringBootApplication
public class UpdateParentFieldApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdateParentFieldApplication.class, args);
    }

}
