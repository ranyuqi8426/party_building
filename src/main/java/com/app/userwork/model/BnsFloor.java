package com.app.userwork.model;

import java.util.Date;

public class BnsFloor {
	private int floor_id;// 主键
	private String floor_name;// 楼宇名称
	private String floor_address;// 楼宇地址
	private String floor_remarks;// 描述
	private String floor_img;// 图片
	private String longitude;// 经度
	private String latitude;// 维度
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getFloor_name() {
		return floor_name;
	}
	public void setFloor_name(String floor_name) {
		this.floor_name = floor_name;
	}
	public String getFloor_address() {
		return floor_address;
	}
	public void setFloor_address(String floor_address) {
		this.floor_address = floor_address;
	}
	public String getFloor_remarks() {
		return floor_remarks;
	}
	public void setFloor_remarks(String floor_remarks) {
		this.floor_remarks = floor_remarks;
	}
	public String getFloor_img() {
		return floor_img;
	}
	public void setFloor_img(String floor_img) {
		this.floor_img = floor_img;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
