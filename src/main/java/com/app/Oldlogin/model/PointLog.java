package com.app.Oldlogin.model;

import java.util.Date;

/**
 * 积分日志表
 */
public class PointLog {
	
	
	private int point_log_id;// id
	private int user_id;//用户id
	private int point_num;//积分
	private String point_type;//积分类型//1视频//3理论//2书籍//4签到
	private Date create_date;//创建时间
	public int getPoint_log_id() {
		return point_log_id;
	}
	public void setPoint_log_id(int point_log_id) {
		this.point_log_id = point_log_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPoint_num() {
		return point_num;
	}
	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}
	public String getPoint_type() {
		return point_type;
	}
	public void setPoint_type(String point_type) {
		this.point_type = point_type;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	
	
}
