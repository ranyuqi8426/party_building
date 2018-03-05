package com.app.Oldlifecircle.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlifecircle.service.PublicBenefitActivitiesService;
import com.app.Oldlifecircle.vo.HappyPartyVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("lifeCircle/PublicBenefitActivities")
public class PublicBenefitActivitiesController {
	@Autowired
	private PublicBenefitActivitiesService PublicBenefitActivitiesService;

	// 查询主列表
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, HappyPartyVO happyPartyVO) {
		List<HappyParty> list = PublicBenefitActivitiesService.list(happyPartyVO);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}

	// 查询一条记录
	@RequestMapping("/getone")
	public void get(HttpServletRequest request, HttpServletResponse response, String listId,String user_id) {
		List<HappyParty> list = PublicBenefitActivitiesService.get(listId,user_id);
		String json = "";
		if (list != null && list.size() > 0) {
			json = JsonUtil.toJsonStr(list, true, "");
		} else {
			json = JsonUtil.toJsonStr(list, false, "加载失败，请稍后重试。");
		}
		WebUtil.out(response, json);

	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, HappyParty happyParty) {
		int flag = PublicBenefitActivitiesService.add(happyParty);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "发布失败，请重新发布。");
		}
		WebUtil.out(response, json);
	}

	/**
	 * 查询我的列表
	 * 
	 * @param request
	 * @param response
	 * @param happyPartyVO
	 */
	@RequestMapping("/melist")
	public void meList(HttpServletRequest request, HttpServletResponse response, HappyPartyVO happyPartyVO) {
		HashMap<String, Object> map = PublicBenefitActivitiesService.meList(happyPartyVO);
		String json = "";
		if (map != null && map.size() > 0) {
			json = "{\"success\":" + true + ",\"list1\":" + JsonUtil.toStr(map.get("1")) + ",\"list2\":" + JsonUtil.toStr(map.get("2")) + "}";
		} else {
			json = JsonUtil.toJsonStr(null, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}
	/// **
	// * 修改
	// */
	// @RequestMapping("/update")
	// public void update(HttpServletRequest request, HttpServletResponse
	/// response, HappyParty happyParty) {
	// int flag = HappyPartyService.update(happyParty);
	// WebUtil.outOpera(response, flag);
	// }
	//
	/// **
	// * 删除
	// */
	// @RequestMapping("/delete")
	// public void delete(HttpServletRequest request, HttpServletResponse
	/// response, String list_id) {
	// int flag = HappyPartyService.delete(list_id);
	// WebUtil.outOpera(response, flag);
	// }
}
