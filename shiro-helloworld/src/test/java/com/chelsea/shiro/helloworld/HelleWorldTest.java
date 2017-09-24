package com.chelsea.shiro.helloworld;

import org.junit.Test;

import com.chelsea.shiro.helloworld.util.ShiroUtil;

public class HelleWorldTest {

	@Test
	public void testHelloworld() {
		String iniPath = "classpath:shiro.ini";
		String username = "zhangsan";
		String password = "123456";
		ShiroUtil.login(iniPath, username, password);
	}

}
