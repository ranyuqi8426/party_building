package com.app.Oldservice.model;

public class Business extends UserBiz{
	private int biz_id;
	private String title;
	private String content;
	private int pic_id;
	private String end_time;
	private String pic_url1;
	private String pic_url2;
	private String pic_url3;
	private String biz_name;
	private String location;
	private String introduction;
	public int getBiz_id() {
		return biz_id;
	}
	public void setBiz_id(int biz_id) {
		this.biz_id = biz_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPic_id() {
		return pic_id;
	}
	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getPic_url1() {
		return pic_url1;
	}
	public void setPic_url1(String pic_url1) {
		this.pic_url1 = pic_url1;
	}
	public String getPic_url2() {
		return pic_url2;
	}
	public void setPic_url2(String pic_url2) {
		this.pic_url2 = pic_url2;
	}
	public String getPic_url3() {
		return pic_url3;
	}
	public void setPic_url3(String pic_url3) {
		this.pic_url3 = pic_url3;
	}
	public String getBiz_name() {
		return biz_name;
	}
	public void setBiz_name(String biz_name) {
		this.biz_name = biz_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}
