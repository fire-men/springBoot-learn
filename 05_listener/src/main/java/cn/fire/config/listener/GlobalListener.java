package cn.fire.config.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.jws.WebService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author:zl
 * @Date:2020/12/22 07:23:40
 * @Userful:
 */
//@Configuration
//public class GlobalListener implements ApplicationListener<ApplicationEvent> {
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        System.out.println("------*********监听器使用**********-----");
//    }
//}

/*  使用Servlet的监听器 */
@WebListener
public class GlobalListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------start------");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------end------");
    }
}
