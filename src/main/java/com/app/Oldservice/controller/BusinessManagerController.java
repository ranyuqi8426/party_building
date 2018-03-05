package com.app.Oldservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Oldservice.model.DataBiz;
import com.app.Oldservice.service.BusinessManagerService;
import com.app.Oldservice.vo.BusinessManagerVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;;

@Controller
@RequestMapping("pc/businessmanager")
public class BusinessManagerController extends BaseController{
	@Autowired
	private BusinessManagerService BusinessManagerService;
	/**
	 * 进入列表主界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/business/list");
		setBtnAutho(request, "businessList");// 设置按钮权限
		return mv;
	}

	/**
	 * 列表
	 * @throws Exception 
	 */
	@RequestMapping("/search")
	public void search(HttpServletRequest request, HttpServletResponse response, BusinessManagerVO BusinessManagerVO) throws Exception {
		int count = BusinessManagerService.listCount(BusinessManagerVO);
		String json = JsonUtil.createExtjsPageJson(count, BusinessManagerService.list(BusinessManagerVO));
		WebUtil.out(response, json);
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, DataBiz DataBiz) {
		DataBiz.setUser_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = BusinessManagerService.add(DataBiz);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, DataBiz DataBiz) {
		DataBiz.setUser_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = BusinessManagerService.update(DataBiz);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	 
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int learning_data_id) {
		int flag = BusinessManagerService.delete(learning_data_id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}
	/**
	 * 获取一条商户信息
	 */
	@RequestMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response, int learning_data_id) {
		int flag = BusinessManagerService.delete(learning_data_id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}
	/**
	 * 进入商户信息主界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/indexinfo")
	public ModelAndView getInfo(HttpServletRequest request) {
		int user_id = SessionUtil.getUserSession(request).getUser_id();
		DataBiz dataBiz = BusinessManagerService.getOne(user_id);
		ModelAndView mv = new ModelAndView();
		if(dataBiz == null){
			mv.setViewName("/business/merchantInfoerror");
			return mv;
		}
		mv.setViewName("/business/merchantInfo");
		mv.addObject("merchantInfo", dataBiz);
		setBtnAutho(request, "businessmerchantInfo");// 设置按钮权限
		return mv;
	}
}
