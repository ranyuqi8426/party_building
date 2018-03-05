package com.app.Oldlifecircle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.service.HappyInfoShowService;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.common.controller.CommonController;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.page.GlobalConst;
import com.app.util.web.WebUtil;

@Controller
@RequestMapping("lifeCircle/HappyInfoShow")
public class HappyInfoShowController extends BaseController {
	@Autowired
	private HappyInfoShowService HappyInfoShowService;

	// 查询主列表
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, HappyInfoShowVO HappyInfoShowVO) {
		List<HappyInfoShow> list = HappyInfoShowService.list(HappyInfoShowVO);
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
	public void get(HttpServletRequest request, HttpServletResponse response, HappyInfoShowVO HappyInfoShowVO) {
		List<HappyInfoShow> list = HappyInfoShowService.get(HappyInfoShowVO);
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
	public void add(HttpServletRequest request, HttpServletResponse response, HappyInfoShow HappyInfoShow) {
		int flag = HappyInfoShowService.add(HappyInfoShow);
		String json = "";
		if (flag == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		} else {
			json = JsonUtil.createOperaStr(false, "发布失败，请重新发布。");
		}
		WebUtil.out(response, json);
	}
	/*
	 * 点赞
	 */
	@RequestMapping("/addUserShow")
	public void addUserShow(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = HappyInfoShowService.addUserShow(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "操作成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "操作失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	/*
	 * 取消点赞
	 */
	@RequestMapping("/deleteUserShow")
	public void deleteUserShow(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = HappyInfoShowService.deleteUserShow(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "操作成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "操作失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	/*
	 * 收藏
	 */
	@RequestMapping("/addCollection")
	public void addCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = HappyInfoShowService.addCollection(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "收藏成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "收藏失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	/*
	 * 取消收藏
	 */
	@RequestMapping("/deleteCollection")
	public void deleteCollection(HttpServletRequest request, HttpServletResponse response,int listId,int user_id){
		int flag = HappyInfoShowService.deleteCollection(listId,user_id);
		String json = "";
		if (flag == 1) {
			json =JsonUtil.createOperaStr(true, "取消成功！");
		}else {
			json =JsonUtil.createOperaStr(false, "取消失败，请重新操作。");
		
		}
		WebUtil.out(response, json);
		
	}
	
	
	


}
