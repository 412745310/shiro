package com.chelsea.shiro.spring.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.chelsea.shiro.spring.entity.User;

public interface UserDao {

	/**
	 * 查询用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public User getByUserName(@Param("userName") String userName);

	/**
	 * 查询角色列表
	 * 
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(@Param("userName") String userName);

	/**
	 * 查询权限列表
	 * 
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(@Param("userName") String userName);

}
