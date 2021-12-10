package cn.fire.validate;

import cn.fire.validate.domain.User;

/**
 * @Author zhangle
 * @CreateTime 2021-10-14 16:38:11
 * @Description
 */
public class Test {

    public void validateTest() {
        User user = new User();
        user.setEmail("2667160750");
        System.out.println(user);
    }

    public static void main(String[] args) {
        new Test().validateTest();
    }
}
