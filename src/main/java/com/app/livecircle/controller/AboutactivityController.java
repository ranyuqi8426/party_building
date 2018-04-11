package com.app.livecircle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.livecircle.model.Aboutactivity;
import com.app.livecircle.model.AboutactivityType;
import com.app.livecircle.model.AboutactivityTypeRelation;
import com.app.livecircle.model.AboutactivityUser;
import com.app.livecircle.service.AboutactivityService;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


@RequestMapping("/aboutActivity")
@Controller
public class AboutactivityController {
	
	@Autowired
	private AboutactivityService aboutactivityService;
	/**
	 * 约吧活动类型查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listType")
	public void listType(HttpServletRequest request, HttpServletResponse response) {
		{
			List<AboutactivityType> list = aboutactivityService.listType();
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
	 * 约吧活动类型私人订制查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listTypeRelation")
	public void listTypeRelation(HttpServletRequest request, HttpServletResponse response,String user_id) {
		{
			List<AboutactivityTypeRelation> list = aboutactivityService.listTypeRelation(user_id);
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
	 * 约吧活动列表查询
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response,String floor_id,String flooractivity_type,int pageSize) {
		{
			List<Aboutactivity> list = aboutactivityService.list(floor_id,flooractivity_type,pageSize);
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
	 * 约吧活动详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response,String user_id,String list_id) {
		{
			String json = "";
			Aboutactivity building = aboutactivityService.get(user_id,list_id);
			if (building != null ) {
			json = JsonUtil.toJsonStr(building, true, "");
			}else {
				json = JsonUtil.toJsonStr(building, false, "暂无数据！");
			}
			WebUtil.out(response, json);
		}
	}
	/**
	 * 新建活动
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Aboutactivity aboutactivity) {
		int falg = aboutactivityService.add(aboutactivity);
		String json = "";
		
		if (falg == 1) {
			json = JsonUtil.createOperaStr(true, "发布成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "发布失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 收藏
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/like")
	public void addLike(HttpServletRequest request, HttpServletResponse response,int user_id,String list_id,String type,String content) {
		int falg = aboutactivityService.addLike(user_id,list_id,type,content);
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
		int falg = aboutactivityService.deleteLike(list_id,user_id,type );
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
	public void addUser(HttpServletRequest request, HttpServletResponse response,AboutactivityUser aboutactivityUser) {
		int falg = aboutactivityService.addUser(aboutactivityUser);
		String json = "";
		
		if (falg == 1 ) {
			json = JsonUtil.createOperaStr(true, "参与成功！");
		}else if (falg == 2 ) {
			json = JsonUtil.createOperaStr(true, "您已参与该活动！");
		}else {
			json = JsonUtil.createOperaStr(false, "参与失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 清空私人订制
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	@RequestMapping("/deleteTypeRelation")
	public void deleteTypeRelation(HttpServletRequest request, HttpServletResponse response,String user_id) {
		int falg = aboutactivityService.deleteTypeRelation(user_id);
		String json = "";
		
		if (falg >0) {
			json = JsonUtil.createOperaStr(true, "清空成功！");
		}else {
			json = JsonUtil.createOperaStr(false, "清空失败！");
		}
		WebUtil.out(response, json);
	}
	/**
	 * 我的 活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * 活动类型 1我发布 2 我参与
	 * @return
	 */
	@RequestMapping("/listMy")
	public void listMy(HttpServletRequest request, HttpServletResponse response,String user_id,String type,int pageSize) {
		List<Aboutactivity> list = aboutactivityService.listMy(user_id,type,pageSize);
		String json = "";
		
		if (list != null && list.size()>0) {
			json = JsonUtil.toJsonStr(list, true, "");
		}else {
			json = JsonUtil.toJsonStr(list, false, "暂无数据！");
		}
		WebUtil.out(response, json);
	}
	
}
