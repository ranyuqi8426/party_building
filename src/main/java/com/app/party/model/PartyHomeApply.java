package com.app.party.model;

import java.util.Date;
/**
 * 找组织
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class PartyHomeApply {
	private int partyhome_apply_id;// 主键
	private int floor_id;// 楼宇ID
	private String company_name;// 单位名称
	private String apply_num;// 党员人数
	private String phone;// 联系人电话
	private String user_name;// 联系人
	private String company_position;// 单位地址
	private String apply_status;// 状态
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getPartyhome_apply_id() {
		return partyhome_apply_id;
	}
	public void setPartyhome_apply_id(int partyhome_apply_id) {
		this.partyhome_apply_id = partyhome_apply_id;
	}
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getApply_num() {
		return apply_num;
	}
	public void setApply_num(String apply_num) {
		this.apply_num = apply_num;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCompany_position() {
		return company_position;
	}
	public void setCompany_position(String company_position) {
		this.company_position = company_position;
	}
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
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
