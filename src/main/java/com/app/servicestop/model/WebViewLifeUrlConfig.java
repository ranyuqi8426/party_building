package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class WebViewLifeUrlConfig {
	private int life_configurl_id;// 主键
	private int life_config_id;//
	private String life_configurl_icon;// 生活ID
	private String life_configurl_name;// 商家名称
	private String life_configurl_url;// 商家URL
	private String sort_num;// 排序字段
	private String create_cd;// 创建人
	private String life_configurl_cd;// 商家代码
	private Date create_time;// 创建时间

	public int getLife_configurl_id() {
		return life_configurl_id;
	}

	public void setLife_configurl_id(int life_configurl_id) {
		this.life_configurl_id = life_configurl_id;
	}

	public int getLife_config_id() {
		return life_config_id;
	}

	public void setLife_config_id(int life_config_id) {
		this.life_config_id = life_config_id;
	}

	public String getLife_configurl_icon() {
		return life_configurl_icon;
	}

	public void setLife_configurl_icon(String life_configurl_icon) {
		this.life_configurl_icon = life_configurl_icon;
	}

	public String getLife_configurl_name() {
		return life_configurl_name;
	}

	public void setLife_configurl_name(String life_configurl_name) {
		this.life_configurl_name = life_configurl_name;
	}

	public String getLife_configurl_url() {
		return life_configurl_url;
	}

	public void setLife_configurl_url(String life_configurl_url) {
		this.life_configurl_url = life_configurl_url;
	}

	public String getSort_num() {
		return sort_num;
	}

	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
	}

	public String getCreate_cd() {
		return create_cd;
	}

	public void setCreate_cd(String create_cd) {
		this.create_cd = create_cd;
	}

	public String getLife_configurl_cd() {
		return life_configurl_cd;
	}

	public void setLife_configurl_cd(String life_configurl_cd) {
		this.life_configurl_cd = life_configurl_cd;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
