package cn.fire.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhangle
 * @CreateTime 2021-10-21 11:53:15
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "user-datail-info")
public class UserInfoConfig {

    Map<String, String> map = new ConcurrentHashMap() {{
    }};

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
