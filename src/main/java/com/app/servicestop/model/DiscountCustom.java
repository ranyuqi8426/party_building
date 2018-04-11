package com.app.servicestop.model;


/**
 * 
 * 
 * @author 冉玉琦
 * @date 2018年3月5日
 */
public class DiscountCustom {
	private Integer merchant_id;// 商家id
	private String discount_name;// 优惠券标题
	private String code_img;// 二维码图片
	private String merchant_name;// 商家名称
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
	public String getCode_img() {
		return code_img;
	}
	public void setCode_img(String code_img) {
		this.code_img = code_img;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}


}
