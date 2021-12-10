package cn.fire.aop.service;

/**
 * @Author:zl
 * @Date:2020/12/21 11:57:40
 * @Userful:
 */
public interface IHelloService {
    String say(String username);

    void insertStudentInfo();

    void batchInsertStudentInfo();

    void batchInsertStudentInfo2();
}
