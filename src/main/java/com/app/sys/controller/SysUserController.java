package com.app.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.sys.model.SysUser;
import com.app.sys.service.SysUserLoginService;
import com.app.sys.service.SysUserService;
import com.app.sys.vo.SysUserSearchVO;
import com.app.util.controller.BaseController;
import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.web.WebUtil;

/**
 * 用户管理
 * @author chykong
 * @date 2016-12-06
 */
@RequestMapping("/sys/user")
@Controller
public class SysUserController extends BaseController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserLoginService sysUserLoginService;

	/**
	 * 进入用户维护界面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/user");
		setBtnAutho(request, "SysUser");
		return mv;
	}

	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @param sysUser
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) {
		sysUser.setCreate_person(SessionUtil.getUserSession(request).getRealname());
		sysUser.setCreate_id(SessionUtil.getUserSession(request).getUser_id());//创建人id
		int flag = sysUserService.add(sysUser);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
		else if (flag == 2)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "用户代码已存在"));
	}

	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @param sysUser
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) {
		int flag = sysUserService.update(sysUser);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "保存失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "保存成功"));
	}

	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = sysUserService.delete(id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "删除失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
	}


	/**
	 * 重置密码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/resetPass")
	public void resetPass(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = sysUserService.saveResetPass(id);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
	}

	/**
	 * 用户锁定和解锁，状态由1变为2或2变为1
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/lockUser")
	public void lockUser(HttpServletRequest request, HttpServletResponse response, int id) {
		int status = WebUtil.getSafeInt(request.getParameter("status"));
		int flag = sysUserService.updaappatus(id, status);
		if (flag == 0)
			WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
		else if (flag == 1)
			WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
	}


	/**
	 * 用户grid列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listAllSysUser")
	public void listAllSysUser(HttpServletRequest request, HttpServletResponse response,
			SysUserSearchVO sysUserSearchVO) {
		String json = JsonUtil.toStr(sysUserService.listAllUser(SessionUtil.getUserSession(request).getUser_id()));
		WebUtil.out(response, json);
	}
}
