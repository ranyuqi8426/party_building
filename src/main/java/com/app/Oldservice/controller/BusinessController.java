package com.app.Oldservice.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldservice.model.Business;
import com.app.Oldservice.model.UserBiz;
import com.app.Oldservice.service.BusinessService;
import com.app.Oldservice.vo.BusinessVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("service/Business")
public class BusinessController {
	@Autowired
	private BusinessService businessService;

	// 展示商家优惠表数据
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, BusinessVO buinessVO) {
		List<Business> list = businessService.list(buinessVO);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);
	}

	// 将商家优惠券加入自己的用户优惠库中
	// TODO 不能重复领
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, UserBiz userBiz) {
		int flag = businessService.add(userBiz);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "领取成功！");
		} else if (flag == 0) {
			json = JsonUtil.createOperaStr(false, "领取失败，已领取。");
		} else {
			json = JsonUtil.createOperaStr(false, "领取失败，请重新领取。");
		}
		WebUtil.out(response, json);
	}

	// 我的
	// 查看自己的优惠券（这个只在我的）
	@RequestMapping("myBus")
	public void myBus(HttpServletRequest request, HttpServletResponse response, BusinessVO buinessVO) {
		HashMap<String, Object> map = businessService.listMe(buinessVO);
		String json = "";
		if (map != null && map.size() > 0) {
			json = "{\"success\":" + true + ",\"list1\":" + JsonUtil.toStr(map.get("1")) + ",\"list2\":" + JsonUtil.toStr(map.get("2")) + "}";
		} else {
			json = JsonUtil.toJsonStr(null, false, "暂无数据");
		}
		WebUtil.out(response, json);
	}

	/**
	 * 使用优惠券
	 * 
	 * @param request
	 * @param response
	 * @param happyParty
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, String id) {
		int flag = businessService.update(id);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "使用完毕！");
		} else {
			json = JsonUtil.createOperaStr(false, "使用失败，请重新操作。");
		} 
		WebUtil.out(response, json);
	}

	// 我的
	// 丢弃优惠券
	@RequestMapping("dropBus")
	public void dropBus(HttpServletRequest request, HttpServletResponse response, String id) {
		int flag = businessService.delete(id);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "删除成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "删除失败，请重新操作。");
		} 
		WebUtil.out(response, json);
	}
}
