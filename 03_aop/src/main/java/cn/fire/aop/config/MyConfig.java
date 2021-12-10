package cn.fire.aop.config;

import cn.fire.aop.domain.User;
import cn.fire.aop.service.Userservice;
import cn.fire.aop.service.impl.UserserviceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 14:15:34
 * @Description
 */
@Configuration
public class MyConfig {

    @Bean(name = "user")
    @ConditionalOnMissingBean(value = User.class)
    public Userservice userservice(){
        return new UserserviceImpl();
    }
}
