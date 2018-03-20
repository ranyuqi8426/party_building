package com.app.userwork.model;

import java.util.Date;

public class UserPoint {
	private int point_id;// 主键
	private int user_id;// 用户id
	private String add_point;// 获得积分
	private String reduce_point;// 使用积分
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getPoint_id() {
		return point_id;
	}
	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAdd_point() {
		return add_point;
	}
	public void setAdd_point(String add_point) {
		this.add_point = add_point;
	}
	public String getReduce_point() {
		return reduce_point;
	}
	public void setReduce_point(String reduce_point) {
		this.reduce_point = reduce_point;
	}
	public String getCreate_cd() {
		return create_cd;
	}
	public void setCreate_cd(String create_cd) {
		this.create_cd = create_cd;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	

}
