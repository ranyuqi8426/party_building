package com.app.userwork.model;

import java.util.Date;

public class MerchantInfo {
	private Integer merchant_id;// 主键
	private Integer floor_id;// 楼宇ID
	private String merchant_name;// 商家名称
	private String merchant_content;// 商家简介
	private String merchant_position;// 商家位置
	private String merchant_img;// 营业执照
	private String contacts;// 联系人
	private String contact_number;// 联系电话
	private String legal_persion;// 法人
	private String merchant_status;// 商家状态(0未审核1审核通过2审核未通过)
	private String create_cd;// 创建人(待确定：用户id)
	private Date create_time;// 创建时间
	public Integer getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(Integer merchant_id) {
		this.merchant_id = merchant_id;
	}
	public Integer getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(Integer floor_id) {
		this.floor_id = floor_id;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public String getMerchant_content() {
		return merchant_content;
	}
	public void setMerchant_content(String merchant_content) {
		this.merchant_content = merchant_content;
	}
	public String getMerchant_position() {
		return merchant_position;
	}
	public void setMerchant_position(String merchant_position) {
		this.merchant_position = merchant_position;
	}
	public String getMerchant_img() {
		return merchant_img;
	}
	public void setMerchant_img(String merchant_img) {
		this.merchant_img = merchant_img;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getLegal_persion() {
		return legal_persion;
	}
	public void setLegal_persion(String legal_persion) {
		this.legal_persion = legal_persion;
	}
	public String getMerchant_status() {
		return merchant_status;
	}
	public void setMerchant_status(String merchant_status) {
		this.merchant_status = merchant_status;
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
