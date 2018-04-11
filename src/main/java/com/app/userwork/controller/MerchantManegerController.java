package com.app.userwork.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.servicestop.model.UserDiscount;
import com.app.userwork.model.MerchantDiscount;
import com.app.userwork.model.MerchantInfo;
import com.app.userwork.service.MerchantManegerService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/MerchantManeger")
@Controller
public class MerchantManegerController {
	
	@Autowired
	private MerchantManegerService merchantManegerService;
	

	/**
	 * 申请商家
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param merchantInfo
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,MerchantInfo merchantInfo) {
			int flag = merchantManegerService.add(merchantInfo);
			String json = "";
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "申请成功！");
			}else if (flag == 2){
				json = JsonUtil.createOperaStr(false, "您已提交申请！");
			}else {
				json = JsonUtil.createOperaStr(false, "申请失败！");
			}
			WebUtil.out(response, json);
		}
	
	/**
	 * 发布优惠活动
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param merchantInfo
	 */
	@RequestMapping("/addDiscount")
	public void addDiscount(HttpServletRequest request, HttpServletResponse response,MerchantDiscount merchantDiscount) {
			int flag = merchantManegerService.addDiscount(merchantDiscount);
			String json = "";
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "发布成功！");
			}else if (flag == 2){
				json = JsonUtil.createOperaStr(false, "您已发布！");
			}else {
				json = JsonUtil.createOperaStr(false, "发布失败！");
			}
			WebUtil.out(response, json);
		}
	/**
	 * 商家活动查询
	 * @author 冉玉琦
	 * @date 2018年4月8日
	 * @param request
	 * @param response
	 * @param user_id
	 * @param type
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String user_id,String type,int pageSize) {
		List<MerchantDiscount> list = merchantManegerService.list(user_id,type,pageSize);
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	
	
	/**
	 * 商家活动使用情况查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/listUse")
	public void listUse(HttpServletRequest request, HttpServletResponse response,int discount_id,int pageSize) {
		List<UserDiscount> list = merchantManegerService.listUse(discount_id,pageSize);
		String json = "";
		
		if (list != null) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 兑换优惠券
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param 
	 */
	@RequestMapping("/addExchange")
	public void addExchange(HttpServletRequest request, HttpServletResponse response,String user_id,String operation_no) {
			int flag = merchantManegerService.addExchange(user_id,operation_no);
			String json = "";
			if (flag == 1) {
				json = JsonUtil.createOperaStr(true, "兑换成功！");
			}else if (flag == 2){
				json = JsonUtil.createOperaStr(false, "服务异常，兑换失败！");
			}else {
				json = JsonUtil.createOperaStr(false, "兑换失败，该商家暂无此优惠券！");
			}
			WebUtil.out(response, json);
		}
	
}
