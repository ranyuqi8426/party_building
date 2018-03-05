package com.app.Oldlifecircle.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlifecircle.service.HappyPartyService;
import com.app.Oldlifecircle.vo.HappyPartyVO;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("lifeCircle/HappyParty")
public class HappyPartyController {
	@Autowired
	private HappyPartyService HappyPartyService;

	// 查询主列表
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, HappyPartyVO happyPartyVO) {
		List<HappyParty> list = HappyPartyService.list(happyPartyVO);
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
	public void get(HttpServletRequest request, HttpServletResponse response, String listId, String user_id) {
		List<HappyParty> list = HappyPartyService.get(listId, user_id);
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
		int flag = HappyPartyService.add(happyParty);
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
	public void listMe(HttpServletRequest request, HttpServletResponse response, HappyPartyVO happyPartyVO) {
		HashMap<String, Object> map = HappyPartyService.listMe(happyPartyVO);
		String json = "";
		if (map != null && map.size() > 0) {
			json = "{\"success\":" + true + ",\"list1\":" + JsonUtil.toStr(map.get("1")) + ",\"list2\":" + JsonUtil.toStr(map.get("2")) + "}";
		} else {
			json = JsonUtil.toJsonStr(null, false, "暂无数据");
		}
		WebUtil.out(response, json);

	}

	/*
	 * 参与活动
	 */
	@RequestMapping("/addUserActivity")
	public void addUserActivity(HttpServletRequest request, HttpServletResponse response, int listId, int user_id) {
		int flag = HappyPartyService.addUserActivity(listId, user_id);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "参与成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "参与失败，请重新操作。");

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
