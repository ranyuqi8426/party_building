package com.app.livecircle.model;

import java.util.Date;

public class Aboutactivity {
	private int aboutactivity_id;// 主键
	private int floor_id;// 楼宇ID
	private String aboutactivity_name;// 活动主题
	private Date aboutactivity_start_time;// 活动开始时间
	private Date aboutactivity_end_time;// 活动结束时间
	private String aboutactivity_num;// 活动人数
	private String aboutactivity_content;// 活动内容
	private String aboutactivity_type;// 活动类型
	private String aboutactivity_status;// 活动状态活动状态(1未审核 2审核通过 3审核未通过)
	private int come_num;// 参与人数（默认1）
	private String aboutactivity_img;// 活动图片
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	
	private String collection_id;// 收藏id
	public int getAboutactivity_id() {
		return aboutactivity_id;
	}
	public void setAboutactivity_id(int aboutactivity_id) {
		this.aboutactivity_id = aboutactivity_id;
	}
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getAboutactivity_name() {
		return aboutactivity_name;
	}
	public void setAboutactivity_name(String aboutactivity_name) {
		this.aboutactivity_name = aboutactivity_name;
	}
	public Date getAboutactivity_start_time() {
		return aboutactivity_start_time;
	}
	public void setAboutactivity_start_time(Date aboutactivity_start_time) {
		this.aboutactivity_start_time = aboutactivity_start_time;
	}
	public Date getAboutactivity_end_time() {
		return aboutactivity_end_time;
	}
	public void setAboutactivity_end_time(Date aboutactivity_end_time) {
		this.aboutactivity_end_time = aboutactivity_end_time;
	}
	public String getAboutactivity_num() {
		return aboutactivity_num;
	}
	public void setAboutactivity_num(String aboutactivity_num) {
		this.aboutactivity_num = aboutactivity_num;
	}
	public String getAboutactivity_content() {
		return aboutactivity_content;
	}
	public void setAboutactivity_content(String aboutactivity_content) {
		this.aboutactivity_content = aboutactivity_content;
	}
	public String getAboutactivity_type() {
		return aboutactivity_type;
	}
	public void setAboutactivity_type(String aboutactivity_type) {
		this.aboutactivity_type = aboutactivity_type;
	}
	public String getAboutactivity_status() {
		return aboutactivity_status;
	}
	public void setAboutactivity_status(String aboutactivity_status) {
		this.aboutactivity_status = aboutactivity_status;
	}
	public int getCome_num() {
		return come_num;
	}
	public void setCome_num(int come_num) {
		this.come_num = come_num;
	}
	public String getAboutactivity_img() {
		return aboutactivity_img;
	}
	public void setAboutactivity_img(String aboutactivity_img) {
		this.aboutactivity_img = aboutactivity_img;
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
	public String getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(String collection_id) {
		this.collection_id = collection_id;
	}

}
