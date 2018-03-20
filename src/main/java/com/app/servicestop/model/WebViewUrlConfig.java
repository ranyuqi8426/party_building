package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class WebViewUrlConfig {
	private int merchant_configurl_id;// 主键
	private int merchant_config_id;// 商务ID
	private String merchant_configurl_cd;// 商家代码（配置链接暂不用）
	private String merchant_configurl_icon;// 商家图标
	private String merchant_configurl_name;// 商家名称
	private String merchant_configurl_url;// 商家URL
	private String sort_num;// 排序字段
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getMerchant_configurl_id() {
		return merchant_configurl_id;
	}
	public void setMerchant_configurl_id(int merchant_configurl_id) {
		this.merchant_configurl_id = merchant_configurl_id;
	}
	public int getMerchant_config_id() {
		return merchant_config_id;
	}
	public void setMerchant_config_id(int merchant_config_id) {
		this.merchant_config_id = merchant_config_id;
	}
	public String getMerchant_configurl_cd() {
		return merchant_configurl_cd;
	}
	public void setMerchant_configurl_cd(String merchant_configurl_cd) {
		this.merchant_configurl_cd = merchant_configurl_cd;
	}
	public String getMerchant_configurl_icon() {
		return merchant_configurl_icon;
	}
	public void setMerchant_configurl_icon(String merchant_configurl_icon) {
		this.merchant_configurl_icon = merchant_configurl_icon;
	}
	public String getMerchant_configurl_name() {
		return merchant_configurl_name;
	}
	public void setMerchant_configurl_name(String merchant_configurl_name) {
		this.merchant_configurl_name = merchant_configurl_name;
	}
	public String getMerchant_configurl_url() {
		return merchant_configurl_url;
	}
	public void setMerchant_configurl_url(String merchant_configurl_url) {
		this.merchant_configurl_url = merchant_configurl_url;
	}
	public String getSort_num() {
		return sort_num;
	}
	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
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
