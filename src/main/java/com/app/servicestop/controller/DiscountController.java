package com.app.servicestop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.servicestop.model.Discount;
import com.app.servicestop.model.DiscountCustom;
import com.app.servicestop.model.UserDiscount;
import com.app.servicestop.service.DiscountService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/discount")
@Controller
public class DiscountController {
	
	@Autowired
	private DiscountService discountService;


	/**
	 * 优惠列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floor_id,int pageSize) {
		{
			List<Discount> list = discountService.list(floor_id,pageSize);
			String json = "";
			
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 优惠劵查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,int merchant_discount_id) {
		{
			Discount discount = discountService.get(merchant_discount_id);
			String json = "";
			
			if (discount != null) {
				json = JsonUtil.toJsonStr(discount, true, "");
			}else {
				json = JsonUtil.toJsonStr(discount, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 领取优惠
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Discount discount) {
		{
			int flag = discountService.add(discount);
			String json = "";
			
			if (flag == 6) {
				json = JsonUtil.createOperaStr(true, "领取成功！");
			}else if (flag == 1) {
				json = JsonUtil.createOperaStr(false, "领取人数超限！");
			}else if (flag == 2) {
				json = JsonUtil.createOperaStr(false, "您已领取！");
			}else if (flag == 3) {
				json = JsonUtil.createOperaStr(false, "积分不足！");
			}else{
				json = JsonUtil.createOperaStr(false, "领取失败！");
			}
			WebUtil.out(response, json);
		}
	}

	/**
	 * 我的  优惠劵列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * type_id  0未兑换1已兑换2已过期
	 * @return
	 */
	@RequestMapping("/listUserMy")
		public void listUserMy(HttpServletRequest request, HttpServletResponse response,int user_id,int type_id,int pageSize){
		{
			List<UserDiscount> list = discountService.listUserMy(user_id, type_id,pageSize);
			String json = "";
			
			if (list != null && list.size()>0) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	
	/**
	 * 我的  生成兑换码
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * type_id  0未兑换1已兑换2已过期
	 * @return
	 */
	@RequestMapping("/queryQRcode")
		public void queryQRcode(HttpServletRequest request, HttpServletResponse response,String operation_no){
		{
			DiscountCustom discountCustom = discountService.queryQRcode(operation_no);
			String json = "";
			
			if (discountCustom != null) {
				json = JsonUtil.toJsonStr(discountCustom, true, "");
			}else {
				json = JsonUtil.toJsonStr(discountCustom, false, "生成失败！");
			}
			WebUtil.out(response, json);
		}
	}
}
