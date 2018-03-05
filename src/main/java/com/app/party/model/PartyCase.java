package com.app.party.model;

import java.util.Date;
/**
 * 身边榜样
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class PartyCase {
	private int party_case_id;// 党员事迹（身边榜样）表主键
	private String party_case_name;// 标题
	private String party_case_conent;// 内容
	private String party_case_img;// 图片
	private String party_case_time;// 发布时间
//	private String sort_num;// 排序字段
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	private String floor_id;// 楼宇ID
	private String is_top;// 是否置顶
	private String is_top_img;// 如果置顶，上传一张大图
	public int getParty_case_id() {
		return party_case_id;
	}
	public void setParty_case_id(int party_case_id) {
		this.party_case_id = party_case_id;
	}
	public String getParty_case_name() {
		return party_case_name;
	}
	public void setParty_case_name(String party_case_name) {
		this.party_case_name = party_case_name;
	}
	public String getParty_case_conent() {
		return party_case_conent;
	}
	public void setParty_case_conent(String party_case_conent) {
		this.party_case_conent = party_case_conent;
	}
	public String getParty_case_img() {
		return party_case_img;
	}
	public void setParty_case_img(String party_case_img) {
		this.party_case_img = party_case_img;
	}
	public String getParty_case_time() {
		return party_case_time;
	}
	public void setParty_case_time(String party_case_time) {
		this.party_case_time = party_case_time;
	}
//	public String getSort_num() {
//		return sort_num;
//	}
//	public void setSort_num(String sort_num) {
//		this.sort_num = sort_num;
//	}
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
	public String getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(String floor_id) {
		this.floor_id = floor_id;
	}
	public String getIs_top() {
		return is_top;
	}
	public void setIs_top(String is_top) {
		this.is_top = is_top;
	}
	public String getIs_top_img() {
		return is_top_img;
	}
	public void setIs_top_img(String is_top_img) {
		this.is_top_img = is_top_img;
	}

}
