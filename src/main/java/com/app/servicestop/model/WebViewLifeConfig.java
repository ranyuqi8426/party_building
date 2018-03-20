package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class WebViewLifeConfig {
	private int life_config_id;// 主键
	private String life_config_cd;// 商家代码(配置链接暂不用)
	private String life_config_name;// 页面（商家）名称
	private String life_config_icon;// 页面（商家）图标
	private String life_config_url;// 生活URL
	private String sort_num;// 排序字段
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	private int is_next;// 判断是否有下一层级列表，默认为0，没有下一层级列表，直接设置LIFE_CONFIG_URL如果有下一层级，设置为1，LIFE_CONFIG_URL设置为空
	public int getLife_config_id() {
		return life_config_id;
	}
	public void setLife_config_id(int life_config_id) {
		this.life_config_id = life_config_id;
	}
	public String getLife_config_cd() {
		return life_config_cd;
	}
	public void setLife_config_cd(String life_config_cd) {
		this.life_config_cd = life_config_cd;
	}
	public String getLife_config_name() {
		return life_config_name;
	}
	public void setLife_config_name(String life_config_name) {
		this.life_config_name = life_config_name;
	}
	public String getLife_config_icon() {
		return life_config_icon;
	}
	public void setLife_config_icon(String life_config_icon) {
		this.life_config_icon = life_config_icon;
	}
	public String getLife_config_url() {
		return life_config_url;
	}
	public void setLife_config_url(String life_config_url) {
		this.life_config_url = life_config_url;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getIs_next() {
		return is_next;
	}
	public void setIs_next(int is_next) {
		this.is_next = is_next;
	}

}
