package com.app.livecircle.model;

import java.util.Date;

public class Building {
	private int flooractivity_id;// 主键
	private String flooractivity_type;// 活动类型（1,精选,2,健康,3,公益,4,讲座,5,舞蹈,6,音乐,7,书画,8,电影,9,美食）
	private String flooractivity_name;// 活动标题
	private String floor_id;// 楼宇ID
	private String floor_name;// 楼宇名称
	private Date flooractivity_starttime;// 活动开始时间
	private Date flooractivity_endtime;// 活动结束时间
	private String flooractivity_content;// 活动内容
	private String flooractivity_img;// 活动图片
	private int flooractivity_status;// 活动状态（0未发布1已发布）

	private String create_cd;// 创建人
	private Date create_time;// 创建时间

	private String collection_id;// 收藏id

	public int getFlooractivity_id() {
		return flooractivity_id;
	}

	public void setFlooractivity_id(int flooractivity_id) {
		this.flooractivity_id = flooractivity_id;
	}

	public String getFlooractivity_type() {
		return flooractivity_type;
	}

	public void setFlooractivity_type(String flooractivity_type) {
		this.flooractivity_type = flooractivity_type;
	}

	public String getFlooractivity_name() {
		return flooractivity_name;
	}

	public void setFlooractivity_name(String flooractivity_name) {
		this.flooractivity_name = flooractivity_name;
	}

	public String getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(String floor_id) {
		this.floor_id = floor_id;
	}

	public String getFloor_name() {
		return floor_name;
	}

	public void setFloor_name(String floor_name) {
		this.floor_name = floor_name;
	}

	public Date getFlooractivity_starttime() {
		return flooractivity_starttime;
	}

	public void setFlooractivity_starttime(Date flooractivity_starttime) {
		this.flooractivity_starttime = flooractivity_starttime;
	}

	public Date getFlooractivity_endtime() {
		return flooractivity_endtime;
	}

	public void setFlooractivity_endtime(Date flooractivity_endtime) {
		this.flooractivity_endtime = flooractivity_endtime;
	}

	public String getFlooractivity_content() {
		return flooractivity_content;
	}

	public void setFlooractivity_content(String flooractivity_content) {
		this.flooractivity_content = flooractivity_content;
	}

	public String getFlooractivity_img() {
		return flooractivity_img;
	}

	public void setFlooractivity_img(String flooractivity_img) {
		this.flooractivity_img = flooractivity_img;
	}

	public int getFlooractivity_status() {
		return flooractivity_status;
	}

	public void setFlooractivity_status(int flooractivity_status) {
		this.flooractivity_status = flooractivity_status;
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
