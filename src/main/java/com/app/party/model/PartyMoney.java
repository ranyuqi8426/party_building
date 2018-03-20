package com.app.party.model;

import java.util.Date;

/**
 * 党费缴纳记录
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class PartyMoney {
	private int party_money_id;// 主键
	private String user_id;// 用户ID
	private Date pay_time;// 缴费日期
	private String pay_money;// 缴费金额
	private String party_home;// 隶属党支部
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	private String user_name;// 用户名称
	public int getParty_money_id() {
		return party_money_id;
	}
	public void setParty_money_id(int party_money_id) {
		this.party_money_id = party_money_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public String getPay_money() {
		return pay_money;
	}
	public void setPay_money(String pay_money) {
		this.pay_money = pay_money;
	}
	public String getParty_home() {
		return party_home;
	}
	public void setParty_home(String party_home) {
		this.party_home = party_home;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
