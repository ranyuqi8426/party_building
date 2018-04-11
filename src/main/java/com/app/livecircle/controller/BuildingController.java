package com.app.livecircle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.livecircle.model.Building;
import com.app.livecircle.model.BuildingUser;
import com.app.livecircle.model.BuildingUserSay;
import com.app.livecircle.service.BuildingService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/building")
@Controller
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;

	
	/**
	 * 楼宇活动列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floor_id,String flooractivity_type,int pageSize) {
		{
			List<Building> list = buildingService.list(floor_id,flooractivity_type,pageSize);
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
	 * 楼宇活动详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
		{
			String json = "";
			Building building = buildingService.get(user_id,list_id);
			if (building != null ) {
			json = JsonUtil.toJsonStr(building, true, "");
			}else {
				json = JsonUtil.toJsonStr(building, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 楼宇活动参与人列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getUserList")
	public void getUserList(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
		{
			String json = "";
			List<BuildingUser> list = buildingService.getUserList(list_id);
			if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无参与人！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 楼宇活动评论列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getUserSayList")
	public void getUserSayList(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id,int pageSize) {
		{
			String json = "";
			List<BuildingUserSay> list = buildingService.getUserSayList(list_id,pageSize);
			if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
			}else {
				json = JsonUtil.toJsonStr(list, false, "暂无评论！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 收藏
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/like")
	public void addLike(HttpServletRequest request, HttpServletResponse response,int user_id,String list_id,String type,String content) {
		int falg = buildingService.addLike(user_id,list_id,type,content);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "收藏成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "收藏失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 取消收藏
	 * @return
	 */
	@RequestMapping("/notlike")
	public void deleteLike(HttpServletRequest request, HttpServletResponse response,int user_id,String list_id,String type) {
		int falg = buildingService.deleteLike(list_id,user_id,type );
		String json = "";
		
		if (falg > 0 ) {
			json = JsonUtil.createOperaStr(true, "取消成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "取消失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 参与活动
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUser
	 * @return
	 */
	@RequestMapping("/addUser")
	public void addUser(HttpServletRequest request, HttpServletResponse response,BuildingUser buildingUser) {
		int falg = buildingService.addUser(buildingUser);
		String json = "";
		
		if (falg > 0 ) {
			json = JsonUtil.createOperaStr(true, "参与成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "参与失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUserSay
	 * @return
	 */
	@RequestMapping("/addUserSay")
	public void addUserSay(HttpServletRequest request, HttpServletResponse response,BuildingUserSay buildingUserSay) {
		int falg = buildingService.addUserSay(buildingUserSay );
		String json = "";
		
		if (falg > 0 ) {
			json = JsonUtil.createOperaStr(true, "评论成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "评论失败！");
		}
		WebUtil.out(response, json);
	}
	
}
