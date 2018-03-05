package com.app.userwork.model;

import java.util.Date;

public class LoopimgConfig {
	private int loopimg_config_id;// 主键
	private String loopimg_config_img;// 轮播图
	private String loopimg_config_content;// 内容
	private String loopimg_config_name;// 标题
	private String source_type;// 来源类型(大类）（1首页，2生活圈）
	private String source_stype;//来源小类(首页 1楼宇活动、2商家活动、3身边榜样  生活圈1楼宇活动 2约吧活动）
	private String sort_num;// 排序字段
	private String source_type_id;// 来源数据ID
	private String is_delete;// 删除标记 y删除 n未删除
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	

	public int getLoopimg_config_id() {
		return loopimg_config_id;
	}
	public void setLoopimg_config_id(int loopimg_config_id) {
		this.loopimg_config_id = loopimg_config_id;
	}
	public String getLoopimg_config_img() {
		return loopimg_config_img;
	}
	public void setLoopimg_config_img(String loopimg_config_img) {
		this.loopimg_config_img = loopimg_config_img;
	}
	public String getLoopimg_config_content() {
		return loopimg_config_content;
	}
	public void setLoopimg_config_content(String loopimg_config_content) {
		this.loopimg_config_content = loopimg_config_content;
	}
	public String getLoopimg_config_name() {
		return loopimg_config_name;
	}
	public void setLoopimg_config_name(String loopimg_config_name) {
		this.loopimg_config_name = loopimg_config_name;
	}
	public String getSource_type() {
		return source_type;
	}
	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}
	public String getSort_num() {
		return sort_num;
	}
	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
	}
	public String getSource_type_id() {
		return source_type_id;
	}
	public void setSource_type_id(String source_type_id) {
		this.source_type_id = source_type_id;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
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
	public String getSource_stype() {
		return source_stype;
	}
	public void setSource_stype(String source_stype) {
		this.source_stype = source_stype;
	}

}
