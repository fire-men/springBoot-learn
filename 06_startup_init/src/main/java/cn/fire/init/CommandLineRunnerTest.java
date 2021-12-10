package cn.fire.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author:zl
 * @Date:2020/12/22 07:46:46
 * @Userful:  CommandLineRunner接口
 *  作用：项目启动时，进行数据初始化操作
 *  执行时机：在项目完全启动后
 */
@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("------数据初始化完成------");
    }
}
