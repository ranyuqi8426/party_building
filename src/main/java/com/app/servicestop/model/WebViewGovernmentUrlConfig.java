package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class WebViewGovernmentUrlConfig {
	private int government_config_id;// 主键
	private int floor_id;// 楼宇ID
	private String gqt_url;// 共青团第三方URL
	private String fl_url;// 妇联第三方URL
	private String gh_url;// 工会第三方URL
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getGovernment_config_id() {
		return government_config_id;
	}
	public void setGovernment_config_id(int government_config_id) {
		this.government_config_id = government_config_id;
	}
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getGqt_url() {
		return gqt_url;
	}
	public void setGqt_url(String gqt_url) {
		this.gqt_url = gqt_url;
	}
	public String getFl_url() {
		return fl_url;
	}
	public void setFl_url(String fl_url) {
		this.fl_url = fl_url;
	}
	public String getGh_url() {
		return gh_url;
	}
	public void setGh_url(String gh_url) {
		this.gh_url = gh_url;
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
