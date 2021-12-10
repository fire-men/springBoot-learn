package cn.fire.aop.service.impl;

import cn.fire.aop.service.IHelloService;
import cn.fire.aop.util.Log;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @Author:zl
 * @Date:2020/12/21 11:58:16
 * @Userful:
 */
@Service("iHelloServiceImpl")
public class IHelloServiceImpl implements IHelloService {

    @Override
    public String say(String username) {
        return username+" say,nice AOP ";
    }

    @Log(action = "添加学生信息")
    public void insertStudentInfo(){
        System.out.println("添加成功....");
    }


    /**
     * 测试：在该方法调用使用AOP代理的方法
     * result: 不打印切面自定义的内容
     */
    @Override
    public void batchInsertStudentInfo() {
        for (int i = 0; i <2; i++) {
            insertStudentInfo();
        }
    }

    /**
     *
     */
    @Override
    public void batchInsertStudentInfo2() {
        IHelloService helloService = (IHelloServiceImpl)AopContext.currentProxy();
        //helloService.insertStudentInfo();

        for (int i = 0; i <2; i++) {
            helloService.insertStudentInfo();
        }
    }
}
