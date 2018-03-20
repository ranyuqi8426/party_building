package com.app.servicestop.model;

import java.util.Date;

/**
 * 咨询问答
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class Discount {
	private Integer merchant_discount_id;// 主键
	private String floor_id;// 楼宇ID
	private Integer merchant_id;// 商家id
	private String discount_name;// 优惠券标题
	private String discount_content;// 优惠券内容
	private String discount_img;// 优惠券图片
	private Date discount_starttime;// 优惠券开始时间
	private Date discount_endtime;// 优惠券结束时间
	private Integer sort_num;// 排序字段
	private String create_cd;// 创建人
	private Date create_time;// 创建时间
	private String discount_fraction;// 设置兑换积分
	private String discount_money;// 优惠券金额
	private Integer discount_num;// 优惠券数量
	
	private Integer num;// 已领取数量

	public Integer getMerchant_discount_id() {
		return merchant_discount_id;
	}

	public void setMerchant_discount_id(Integer merchant_discount_id) {
		this.merchant_discount_id = merchant_discount_id;
	}

	public String getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(String floor_id) {
		this.floor_id = floor_id;
	}

	public Integer getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Integer merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getDiscount_name() {
		return discount_name;
	}

	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}

	public String getDiscount_content() {
		return discount_content;
	}

	public void setDiscount_content(String discount_content) {
		this.discount_content = discount_content;
	}

	public String getDiscount_img() {
		return discount_img;
	}

	public void setDiscount_img(String discount_img) {
		this.discount_img = discount_img;
	}

	public Date getDiscount_starttime() {
		return discount_starttime;
	}

	public void setDiscount_starttime(Date discount_starttime) {
		this.discount_starttime = discount_starttime;
	}

	public Date getDiscount_endtime() {
		return discount_endtime;
	}

	public void setDiscount_endtime(Date discount_endtime) {
		this.discount_endtime = discount_endtime;
	}

	public Integer getSort_num() {
		return sort_num;
	}

	public void setSort_num(Integer sort_num) {
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

	public String getDiscount_fraction() {
		return discount_fraction;
	}

	public void setDiscount_fraction(String discount_fraction) {
		this.discount_fraction = discount_fraction;
	}

	public String getDiscount_money() {
		return discount_money;
	}

	public void setDiscount_money(String discount_money) {
		this.discount_money = discount_money;
	}

	public Integer getDiscount_num() {
		return discount_num;
	}

	public void setDiscount_num(Integer discount_num) {
		this.discount_num = discount_num;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	

}
