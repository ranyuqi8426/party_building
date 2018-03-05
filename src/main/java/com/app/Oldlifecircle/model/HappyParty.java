package com.app.Oldlifecircle.model;

import java.util.Date;

public class HappyParty {
	//用户id
	private int activity_id;
	//活动名称
	private String activity_name;
	//活动内容
	private String content;
	//限制人数
	private int number_total;
	//参加人数
	private int number_real;
	//活动类型 1社团、2公益
	private String type;
	//活动项目
	private String item;
	//开始时间
	private String begin_time;
	//结束时间
	private String end_time;
	//状态1未开始 2已结束 3人数已满 4正常
	private String statue;
	//备注
	private String remark;
	// 图片地址
	private String img_url;
	//审核状态1通过2未通过
	private String audit_status;
	//审核人id
	private int auditor_id;
	//审核时间
	private Date audit_time;
	
	
	
	private 	int	   id;  
	private 	int	   user_id;            
	private 	String	   activity_type;       
	private 	String	   user_type;           
	private	 Date	   create_time;         
	private 	Date	   last_time;
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNumber_total() {
		return number_total;
	}
	public void setNumber_total(int number_total) {
		this.number_total = number_total;
	}
	public int getNumber_real() {
		return number_real;
	}
	public void setNumber_real(int number_real) {
		this.number_real = number_real;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	public int getAuditor_id() {
		return auditor_id;
	}
	public void setAuditor_id(int auditor_id) {
		this.auditor_id = auditor_id;
	}
	public Date getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(Date audit_time) {
		this.audit_time = audit_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}   

	
	

}
