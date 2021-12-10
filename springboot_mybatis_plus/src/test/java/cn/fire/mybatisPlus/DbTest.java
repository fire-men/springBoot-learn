package cn.fire.mybatisPlus;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhangle
 * @CreateTime 2021-10-18 10:34:40
 * @Description
 */
@SpringBootTest
public class DbTest {

    /**
     * 数据源信息加密
     */
    @Test
    void dbConfigTest(){
        //生成16为随机的密钥(保存)
        String randomKey = AES.generateRandomKey();
        System.out.println("密钥："+randomKey);//fa778f0edb6059ef

        //数据加密
        /*
        * jdbc:mysql://127.0.0.1:3306/pro_cloud?useSSL=false&useUnicode=yes&characterEncoding=UTF8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL
        * */
        String url = "jdbc:mysql://127.0.0.1:3306/pro_cloud?useSSL=false&useUnicode=yes&characterEncoding=UTF8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "zl";
        String password = "zl123";
        String url2 = AES.encrypt(url, randomKey);
        String user2 = AES.encrypt(user, randomKey);
        String pssw2 = AES.encrypt(password, randomKey);

        System.out.println(url2);
        System.out.println(user2);
        System.out.println(pssw2);

    }
}
