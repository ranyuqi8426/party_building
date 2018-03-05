package com.app.Oldservice.model;

import java.util.Date;

public class CreateParty {
	private int create_party_id;
	private int user_id;
	private int work_info_id;
	private String company_name;
	private String party_num;
	private String contacts;
	private String contacts_tel;
	private String company_address;
	private String party_status;
	private int audit_id;
	private Date audit_date;
	private Date create_date;
	public int getCreate_party_id() {
		return create_party_id;
	}
	public void setCreate_party_id(int create_party_id) {
		this.create_party_id = create_party_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getWork_info_id() {
		return work_info_id;
	}
	public void setWork_info_id(int work_info_id) {
		this.work_info_id = work_info_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getParty_num() {
		return party_num;
	}
	public void setParty_num(String party_num) {
		this.party_num = party_num;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContacts_tel() {
		return contacts_tel;
	}
	public void setContacts_tel(String contacts_tel) {
		this.contacts_tel = contacts_tel;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getParty_status() {
		return party_status;
	}
	public void setParty_status(String party_status) {
		this.party_status = party_status;
	}
	public int getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}
	public Date getAudit_date() {
		return audit_date;
	}
	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}
