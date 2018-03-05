package com.app.Oldmy.model;

import java.util.Date;

public class RealTimeMessage extends Collection{
	private int realtimeinfo_id;
	private String realtimeinfo_title;
	private String realtimeinfo_content;
	private int read_num;
	private Date realtimeinfo_time;
	private String img_url1;
	private String img_url2;
	private String img_url3;
	private int imgnum = 0;
	private String create_name;
	
	
	public int getRealtimeinfo_id() {
		return realtimeinfo_id;
	}
	public void setRealtimeinfo_id(int realtimeinfo_id) {
		this.realtimeinfo_id = realtimeinfo_id;
	}
	public String getRealtimeinfo_title() {
		return realtimeinfo_title;
	}
	public void setRealtimeinfo_title(String realtimeinfo_title) {
		this.realtimeinfo_title = realtimeinfo_title;
	}
	public String getRealtimeinfo_content() {
		return realtimeinfo_content;
	}
	public void setRealtimeinfo_content(String realtimeinfo_content) {
		this.realtimeinfo_content = realtimeinfo_content;
	}
	public int getRead_num() {
		return read_num;
	}
	public void setRead_num(int read_num) {
		this.read_num = read_num;
	}
	public String getImg_url1() {
		return img_url1;
	}
	public void setImg_url1(String img_url1) {
		this.img_url1 = img_url1;
	}
	public String getImg_url2() {
		return img_url2;
	}
	public void setImg_url2(String img_url2) {
		this.img_url2 = img_url2;
	}
	public String getImg_url3() {
		return img_url3;
	}
	public void setImg_url3(String img_url3) {
		this.img_url3 = img_url3;
	}
	public Date getRealtimeinfo_time() {
		return realtimeinfo_time;
	}
	public void setRealtimeinfo_time(Date realtimeinfo_time) {
		this.realtimeinfo_time = realtimeinfo_time;
	}
	public int getImgnum() {
		return imgnum;
	}
	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
}
