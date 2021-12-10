package cn.fire.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-21 13:33:27
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "simple-info")
@PropertySource("classpath:/myProperties/simple.properties")
public class SimpleInfoConfig {
    List<Object> list =  new ArrayList<Object>();

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }


}
