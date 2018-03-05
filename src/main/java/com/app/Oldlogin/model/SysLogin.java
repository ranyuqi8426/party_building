package com.app.Oldlogin.model;

import java.util.Date;

/**
 * 用户表
 */
public class SysLogin {
	
	
	private int user_id;// id
	private String username;// 用户名
	private String password;// 密码
	private String salt;// 密码加盐
	private String mobile;// 手机号
	private String realname;// 真实名称

	private String age;// 年龄
	private String gender;// 性别
	private String url;// 头像url

	private String status;//状态
	private int role_id;//角色id
	private Date createtime;//创建时间
	private String company;//公司
	private String post;//公司
	private String isdang;//公司
	
	
	
	//1为普通用户
	private int is_mobile_user;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) { 
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getIs_mobile_user() {
		return is_mobile_user;
	}
	public void setIs_mobile_user(int is_mobile_user) {
		this.is_mobile_user = is_mobile_user;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getIsdang() {
		return isdang;
	}
	public void setIsdang(String isdang) {
		this.isdang = isdang;
	}
	
}
