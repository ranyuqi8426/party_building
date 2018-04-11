package com.app.userwork.vo;

public class UserInfoVO {
	private int user_id;// 主键
	private String oldpsd;// 密码
	private String newpsd;// 密码
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOldpsd() {
		return oldpsd;
	}
	public void setOldpsd(String oldpsd) {
		this.oldpsd = oldpsd;
	}
	public String getNewpsd() {
		return newpsd;
	}
	public void setNewpsd(String newpsd) {
		this.newpsd = newpsd;
	}
	
	

	
}
