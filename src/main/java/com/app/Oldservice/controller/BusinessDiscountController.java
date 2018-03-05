package com.app.Oldservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Oldservice.model.Business;
import com.app.Oldservice.service.BusinessDiscountService;
import com.app.Oldservice.vo.BusinessDiscountVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;;

@Controller
@RequestMapping("pc/businessdiscount")
public class BusinessDiscountController extends BaseController{
	@Autowired
	private BusinessDiscountService BusinessDiscountService;
	/**
	 * 进入主界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/business/discount");
		setBtnAutho(request, "businessDiscount");// 设置按钮权限
		return mv;
	}

	/**
	 * 列表
	 * @throws Exception 
	 */
	@RequestMapping("/search")
	public void search(HttpServletRequest request, HttpServletResponse response, BusinessDiscountVO BusinessDiscountVO) throws Exception {
		BusinessDiscountVO.setUser_id(SessionUtil.getUserSession(request).getUser_id());
		int count = BusinessDiscountService.listCount(BusinessDiscountVO);
		String json = JsonUtil.createExtjsPageJson(count, BusinessDiscountService.list(BusinessDiscountVO));
		WebUtil.out(response, json);
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, Business Business) {
		Business.setUser_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = BusinessDiscountService.add(Business);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, Business Business) {
		Business.setUser_id(SessionUtil.getUserSession(request).getUser_id());
		int flag = BusinessDiscountService.update(Business);
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
		int flag = BusinessDiscountService.delete(learning_data_id);
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
		int flag = BusinessDiscountService.delete(learning_data_id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}
}
