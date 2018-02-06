package com.app.Oldservice.model;

import java.util.Date;

import com.app.util.page.SearchPageVO;

public class WorkStation extends SearchPageVO{
	private int work_info_id;
	private String location_desc;
	private String longitude;
	private String latitude;
	private String create_id;
	private Date create_date;
	private String title;
	public int getWork_info_id() {
		return work_info_id;
	}
	public void setWork_info_id(int work_info_id) {
		this.work_info_id = work_info_id;
	}
	public String getLocation_desc() {
		return location_desc;
	}
	public void setLocation_desc(String location_desc) {
		this.location_desc = location_desc;
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
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
