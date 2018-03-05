package com.app.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.sys.model.SysDw;
import com.app.sys.service.SysDwService;
import com.app.sys.vo.SysDwSearchVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;


/**
 * 系统单位Controller
 * @author 孔垂云
 * @date 2016年12月6日
 */
@Controller
@RequestMapping("/sys/dw")
public class SysDwController extends BaseController {

	@Autowired
	private SysDwService sysDwService;

	/**
	 * 进入单位维护界面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/dw");
		setBtnAutho(request, "SysDw");
		return mv;
	}

	/**
	 * 新增单位
	 * @param request
	 * @param response
	 * @param sysUser
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, SysDw sysDw) {
		int flag = sysDwService.add(sysDw);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
		else if (flag == 2)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "单位代码已存在"));
	}

	/**
	 * 修改单位
	 * @param request
	 * @param response
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, SysDw sysDw) {
		int flag = sysDwService.update(sysDw);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}

	/**
	 * 删除单位
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int dwid) {
		int flag = sysDwService.delete(dwid);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
		else if (flag == 2)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "还有子节点，不允许删除"));
	}


	
	/**
	 * 所在单位下拉框列表公共方法
	 * @param request
	 * @param response
	 * @param DWID
	 */
	@RequestMapping("/getComboboxTree")
	public void getComboboxTree(HttpServletRequest request,HttpServletResponse response, String dwid) {
		WebUtil.out(response, JsonUtil.toStr(sysDwService.getComboboxTree(dwid)));
		
	} 

	
}
