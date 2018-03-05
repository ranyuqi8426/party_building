package com.app.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.sys.model.SysFileUpload;
import com.app.sys.service.SysFileUploadService;
import com.app.sys.vo.SysFileUploadVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.web.WebUtil;

@RequestMapping("/sys/fileUpload")
@Controller
public class SysFileUploadController  extends BaseController {
	@Autowired
	private SysFileUploadService sysFileUploadService;

	/**
	 * 进入文电管理表维护界面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/fileUpload");
		setBtnAutho(request, "SysFileUpload");
		return mv;
	}
	/**
	 * 添加文电管理表
	 * @param request
	 * @param response
	 * @param xlDqh
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, SysFileUpload sysFileUpload) {
		int flag = sysFileUploadService.add(sysFileUpload);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	/**
	 * 修改文电管理表
	 * @param request
	 * @param response
	 * @param xlDqh
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, SysFileUpload sysFileUpload) {
		int flag = sysFileUploadService.update(sysFileUpload);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}
	/**
	 * 删除文电管理表
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = sysFileUploadService.delete(id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}

	

}
