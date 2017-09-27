package com.chelsea.shiro.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.chelsea.shiro.web.entity.User;

public class UserDao {

	public User getByUserName(Connection con,String userName)throws Exception{
		User resultUser=null;
		String sql="select * from t_user where name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setName(rs.getString("name"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}

	public Set<String> getRoles(Connection con, String userName) throws Exception{
		Set<String> roles=new HashSet<String>();
		String sql="select r.name from t_user u,t_user_role ur,t_role r where u.id=ur.user_id and ur.role_id=r.id and u.name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			roles.add(rs.getString("name"));
		}
		return roles;
	}

	public Set<String> getPermissions(Connection con, String userName)throws Exception {
		Set<String> permissions=new HashSet<String>();
		String sql="select p.name from t_user u,t_user_role ur,t_role_permission rp,t_permission p "
				+ "where u.id=ur.user_id and ur.role_id=rp.role_id and rp.permission_id=p.id and u.name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			permissions.add(rs.getString("name"));
		}
		return permissions;
	}
}
