package com.app.floorservice.model;


public class WorkStation  {
	private Integer floor_id;// 主键
	private String floor_name;// 楼宇名称
	private String floor_address;// 楼宇地址
	private String floor_remarks;// 描述
	private String floor_img;// 图片
	private String longitude;// 经度
	private String latitude;// 维度
	private String contacts;// 联系人
	private String contact_number;// 联系电话

	public Integer getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(Integer floor_id) {
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

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

}
