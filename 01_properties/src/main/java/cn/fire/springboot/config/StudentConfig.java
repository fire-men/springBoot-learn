package cn.fire.springboot.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @Author:zl
 * @Date:2020/12/20 13:01:43
 * @Userful: 读取自定义配置文件属性 -- 将自定义文件看做一个对象
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "student")
@PropertySource(value = {"classpath:myProperties/student.properties"})
public class StudentConfig {
    private String username;
    private String age;
    private String address;
    private String iPhone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getiPhone() {
        return iPhone;
    }

    public void setiPhone(String iPhone) {
        this.iPhone = iPhone;
    }

    @Override
    public String toString() {
        return "StudentConfig{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", iPhone='" + iPhone + '\'' +
                '}';
    }
}
