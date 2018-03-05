package com.app.party.model;

import java.util.Date;
/**
 * 申请入党
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class PartyApply {
	private int party_apply_id;// 主键
	private int floor_id;// 楼宇ID
	private String apply_name;// 姓名
	private String apply_age;// 年龄
	private String apply_phone;// 手机号
	private String apply_sex;// 性别
	private String apply_status;// 状态
	private String create_cd;// 创建人
	private Date create_time;// 创建时间

	public int getParty_apply_id() {
		return party_apply_id;
	}

	public void setParty_apply_id(int party_apply_id) {
		this.party_apply_id = party_apply_id;
	}

	public int getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}

	public String getApply_name() {
		return apply_name;
	}

	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}

	public String getApply_age() {
		return apply_age;
	}

	public void setApply_age(String apply_age) {
		this.apply_age = apply_age;
	}

	public String getApply_phone() {
		return apply_phone;
	}

	public void setApply_phone(String apply_phone) {
		this.apply_phone = apply_phone;
	}

	public String getApply_sex() {
		return apply_sex;
	}

	public void setApply_sex(String apply_sex) {
		this.apply_sex = apply_sex;
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
