package cn.fire.springboot;

import cn.fire.springboot.config.SimpleInfoConfig;
import cn.fire.springboot.config.UserInfoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserInfoConfig userInfoConfig;

	@Autowired
	private SimpleInfoConfig simpleInfoConfig;

	@Test
	public void getMapPerperties(){
		Map<String, String> infoConfigMap = userInfoConfig.getMap();
		System.out.println(infoConfigMap);
	}

	@Test
	public void getListPerperties(){
		List<Object> infoConfigList = simpleInfoConfig.getList();
		System.out.println(infoConfigList);
	}
}
