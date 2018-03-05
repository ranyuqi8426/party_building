package com.app.Oldlifecircle.model;

import java.util.Date;

public class UserCollection {
	private int id;
	private int collection_id;
	private int user_id;
	private String collection_name;
	private String collection_type;
	private String conllection_url;
	private Date create_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(int collection_id) {
		this.collection_id = collection_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCollection_name() {
		return collection_name;
	}
	public void setCollection_name(String collection_name) {
		this.collection_name = collection_name;
	}
	public String getCollection_type() {
		return collection_type;
	}
	public void setCollection_type(String collection_type) {
		this.collection_type = collection_type;
	}
	public String getConllection_url() {
		return conllection_url;
	}
	public void setConllection_url(String conllection_url) {
		this.conllection_url = conllection_url;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	

}
