package com.app.livecircle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.livecircle.model.Show;
import com.app.livecircle.model.ShowMessage;
import com.app.livecircle.service.ShowService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/show")
@Controller
public class ShowController {
	
	@Autowired
	private ShowService showService;


	/**
	 * 晒晒列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String user_id,String floorid,int pageSize) {
		{
			List<Show> list = showService.list(user_id,pageSize);
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
	 * 点赞
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/like")
	public void addLike(HttpServletRequest request, HttpServletResponse response,String user_id,int list_id) {
		int falg = showService.addLike(list_id,user_id);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "点赞成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "点赞失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	@RequestMapping("/notlike")
	public void deleteLike(HttpServletRequest request, HttpServletResponse response,int user_id,int list_id) {
		int falg = showService.deleteLike(list_id, user_id);
		String json = "";
		
		if (falg > 0 ) {
			json = JsonUtil.createOperaStr(true, "取消成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "取消失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/say")
	public void addSay(HttpServletRequest request, HttpServletResponse response,ShowMessage showMessage) {
		int falg = showService.addSay(showMessage);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "评论成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "评论失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 新增
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Show show) {
		int falg = showService.add(show);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "发布失败！");
		}
		WebUtil.out(response, json);
	}
	
	/**
	 * 我的  晒晒列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listMy")
	public void listMy(HttpServletRequest request, HttpServletResponse response,String user_id,String floorid,int pageSize) {
		{
			List<Show> list = showService.listMy(user_id,pageSize);
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
	 * 我的  晒晒详情查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getMy")
	public void getMy(HttpServletRequest request, HttpServletResponse response,String user_id,String floorid,String show_id) {
		{
			Show list = showService.getMy(user_id,show_id);
			String json = "";
			if (list != null) {
				json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
}
