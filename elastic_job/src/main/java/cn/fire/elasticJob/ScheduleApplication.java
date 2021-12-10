package cn.fire.elasticJob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhangle
 * @CreateTime 2021-10-18 15:03:41
 * @Description
 */
@MapperScan("cn.fire.elasticJob.mapper")
@SpringBootApplication
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
}
