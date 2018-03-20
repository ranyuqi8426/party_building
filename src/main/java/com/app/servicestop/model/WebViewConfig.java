package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class WebViewConfig {
	private int merchant_config_id;// 主键
	private String merchant_config_cd;// 商家代码(配置链接暂不用)
	private String merchant_config_name;// 页面（商家）名称
	private String merchant_config_icon;// 页面（商家）图标
	private String merchant_config_url;// 商务URL
	private int is_next;// 判断是否有下一层级列表，默认为0，没有下一层级列表，直接设置MERCHANT_CONFIGURL_URL；如果有下一层级，设置为1，MERCHANT_CONFIGURL_URL设置为空
	private String sort_num;// 排序字段
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	public int getMerchant_config_id() {
		return merchant_config_id;
	}
	public void setMerchant_config_id(int merchant_config_id) {
		this.merchant_config_id = merchant_config_id;
	}
	public String getMerchant_config_cd() {
		return merchant_config_cd;
	}
	public void setMerchant_config_cd(String merchant_config_cd) {
		this.merchant_config_cd = merchant_config_cd;
	}
	public String getMerchant_config_name() {
		return merchant_config_name;
	}
	public void setMerchant_config_name(String merchant_config_name) {
		this.merchant_config_name = merchant_config_name;
	}
	public String getMerchant_config_icon() {
		return merchant_config_icon;
	}
	public void setMerchant_config_icon(String merchant_config_icon) {
		this.merchant_config_icon = merchant_config_icon;
	}
	public String getMerchant_config_url() {
		return merchant_config_url;
	}
	public void setMerchant_config_url(String merchant_config_url) {
		this.merchant_config_url = merchant_config_url;
	}
	public int getIs_next() {
		return is_next;
	}
	public void setIs_next(int is_next) {
		this.is_next = is_next;
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
