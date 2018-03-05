package com.app.Oldlogin.vo;

import java.util.Date;

/**
 * 用户表
 */
public class SysLoginVO {
	
	
	private String user_id;// id
	private String username;// 用户名
	private String password;// 密码
//	private String salt;// 密码加盐
	private String mobile;// 手机号
//	private Integer realname;// 真实名称

//	private String age;// 年龄
//	private String gender;// 性别、
	private String code;// 验证码

//	private String status;//状态
//	private String role_id;//角色id、
//	private Date createtime;//创建时间、
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
