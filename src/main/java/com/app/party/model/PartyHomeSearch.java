package com.app.party.model;

import java.util.Date;

/**
 * 成立组织
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class PartyHomeSearch {
	private int partyhome_search_id;// 主键
	private int floor_id;// 楼宇id
	private String search_name;// 姓名
	private String search_phone;// 联系电话
	private String search_address;// 居住地址
	private String search_companyname;// 单位名称
	private String search_companyposition;// 职位
	private String search_userno;// 身份证号
	private String search_content;// 申请说明
	private String search_status;// 状态
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getPartyhome_search_id() {
		return partyhome_search_id;
	}
	public void setPartyhome_search_id(int partyhome_search_id) {
		this.partyhome_search_id = partyhome_search_id;
	}
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSearch_phone() {
		return search_phone;
	}
	public void setSearch_phone(String search_phone) {
		this.search_phone = search_phone;
	}
	public String getSearch_address() {
		return search_address;
	}
	public void setSearch_address(String search_address) {
		this.search_address = search_address;
	}
	public String getSearch_companyname() {
		return search_companyname;
	}
	public void setSearch_companyname(String search_companyname) {
		this.search_companyname = search_companyname;
	}
	public String getSearch_companyposition() {
		return search_companyposition;
	}
	public void setSearch_companyposition(String search_companyposition) {
		this.search_companyposition = search_companyposition;
	}
	public String getSearch_userno() {
		return search_userno;
	}
	public void setSearch_userno(String search_userno) {
		this.search_userno = search_userno;
	}
	public String getSearch_content() {
		return search_content;
	}
	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}
	public String getSearch_status() {
		return search_status;
	}
	public void setSearch_status(String search_status) {
		this.search_status = search_status;
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
