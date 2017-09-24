package com.chelsea.shiro.jdbc;

import org.junit.Test;

import com.chelsea.shiro.jdbc.util.ShiroUtil;

public class JdbcTest {

	@Test
	public void test() {
		String iniPath = "classpath:jdbc-realm.ini";
		String username = "java1234";
		String password = "123456";
		ShiroUtil.login(iniPath, username, password);
	}

}
