package com.chelsea.shiro.helloworld.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

@SuppressWarnings("deprecation")
public class ShiroUtil {

	public static Subject login(String iniPath, String username, String password) {
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
		// 获取securityManager实例
		SecurityManager securityManager = factory.getInstance();
		// 把securityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject subject = SecurityUtils.getSubject();
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			// 身份认证
			subject.login(token);
			System.out.println("身份认证成功！");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("身份认证失败！");
		}
		return subject;
	}

}
