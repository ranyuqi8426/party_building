package com.app.Oldlogin.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.app.Oldlogin.dao.LodSysLoginDao;
//import com.app.Oldlogin.dao.SysSignLog;
//import com.app.Oldlogin.model.PointLog;
//import com.app.Oldlogin.model.SysLogin;
//import com.app.Oldlogin.model.SysPoint;
//import com.app.Oldlogin.model.SysSign;
//import com.app.Oldlogin.service.SysLoginService;
//import com.app.Oldlogin.vo.SysLoginVO;
//import com.app.util.constant.ConstantUtil;
//import com.app.util.json.JsonUtil;
//import com.app.util.web.WebUtil;
//
//@RequestMapping("login")
//@Controller
//public class LodLoginController {
//	@Autowired
//	private SysLoginService sysLoginService;
//	@Autowired
//	private LodSysLoginDao sysLoginDao;
//	//登录
//	@RequestMapping("/list")
//	public void list(HttpServletRequest request, HttpServletResponse response,SysLoginVO sysLoginVO){
//		List<SysLogin> list = sysLoginService.list(sysLoginVO);
//		String json = "";
//		if (list != null && list.size()==1) {
//			json = JsonUtil.toJsonStr(list,true,"");
//		}else if(list != null && list.size()==0){
//			json = JsonUtil.toJsonStr(list,false,"用户名或密码错误");
//		}else if(list != null && list.size()>1){
//			json = JsonUtil.toJsonStr(list,false,"账户异常");
//		}
//		if(list != null && list.size()==1 && list.get(0).getStatus() != null && !list.get(0).getStatus().equals("1")){
//			json = JsonUtil.toJsonStr(list,false,"账户已冻结");
//		}
//		WebUtil.out(response, json);
//		
//	}
//	//用户名查重
//		@RequestMapping("/checkname")
//		public void listUserName(HttpServletRequest request, HttpServletResponse response,SysLoginVO sysLoginVO){
//			List<SysLogin> list = sysLoginService.list(sysLoginVO);
//			String json = "";
//			if (list == null || list.size()==0) {
//				json =JsonUtil.createOperaStr(true, "此用户名可以使用");
//			}else {
//				json =JsonUtil.createOperaStr(false, "此用户名已被占用！");
//			}
//			WebUtil.out(response, json);
//			
//		}
//	
//	/**
//	 * 注册
//	 */
//	@RequestMapping("/add")
//	public void add(HttpServletRequest request, HttpServletResponse response, SysLogin SysLogin) {
//		int flag = sysLoginService.add(SysLogin);
//		String json = "";
//		if (flag == 1) {
//			json =JsonUtil.createOperaStr(true, "注册成功！");
//		}else {
//			json =JsonUtil.createOperaStr(false, "注册失败，请重新注册。");
//		
//		}
//		WebUtil.out(response, json);
//	}
//	/**
//	 * 签到
//	 */
//	@RequestMapping("/addSignLog")
//	public void addSign(HttpServletRequest request, HttpServletResponse response, int user_id) {
//		String json = "";
//		int flag = sysLoginService.querySign(user_id);
//		if (flag == 0) {
//			json = JsonUtil.toJsonStr(null,false,"已签到，不能重复签到");
//		}else {
//			List<SysSign> list = sysLoginService.addSign(user_id);
//			
//			if (list != null && list.size() == 1) {
//				json = JsonUtil.toJsonStr(list,true,"签到成功");
//			}else {
//				json = JsonUtil.toJsonStr(list,true,"签到失败");
//			
//			}
//		}
//		WebUtil.out(response, json);
//	}
//	/**
//	 * 获取签到信息 
//	 */
//	@RequestMapping("/getSignLog")
//	public void getSignLog(HttpServletRequest request, HttpServletResponse response, int user_id,int year,int month) {
//		List<SysSignLog> list = sysLoginService.getSignLog(user_id, year, month);
//		List<SysSign> list2 = sysLoginDao.getSignRecord(user_id);
//		String json = "";
//		if (list2 != null && list2.size()>0) {
//			json = "{\"success\":" + true + ",\"list1\":" + JsonUtil.toStr(list) +",\"list2\":" + JsonUtil.toStr(list2) +  "}";
//		}else{
//			json = JsonUtil.toJsonStr(null,false,"加载失败");
//		}
//		WebUtil.out(response, json);
//	}
//	
//	
//	
//	//查询积分规则
//	@RequestMapping("/getpoint")
//	public void getPoint(HttpServletRequest request, HttpServletResponse response,String user_id){
//		List<PointLog> listlog = sysLoginService.getPointLog(user_id);
//		List<SysPoint> list = sysLoginService.getPoint(user_id);
//		String json = "";
//		if (listlog != null && list != null && listlog.size()>0 && list.size()>0) {
//			String listLogJson = JsonUtil.toStr(listlog);
//			String listJson = JsonUtil.toStr(list);
//			json = "{\"success\":" + true + ",\"listLogJson\":" + listLogJson +",\"pointRule\":\"" + ConstantUtil.pointRule + "\",\"listJson\":" + listJson +  "}";
//		}else {
//			json = JsonUtil.toJsonStr(null,false,"加载失败");
//		}
//		WebUtil.out(response, json);
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
////	@RequestMapping("/login")
////	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
////		ModelAndView mv = new ModelAndView();
////		mv.setViewName("/login2");
////		return mv;
//////		CommonDao.test();
//////		return null;
////	}
////
////	/**
////	 * 登录校验
////	 * @param request
////	 * @param response
////	 * @param username
////	 * @param password
////	 */
////	@RequestMapping("/checkLogin")
////	public void checkLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
////		{
////			SysUser sysUser = sysUserService.getByUsername(username);
////			if (sysUser == null || !sysUserService.checkPass(sysUser, password)) {
////				WebUtil.out(response, JsonUtil.createOperaStr(false, "用户名或密码错误"));
////			} else {
////				if (sysUser.getStatus() == 2) {
////					WebUtil.out(response, JsonUtil.createOperaStr(false, "该用户已锁定"));
////				} else {
////					String ip = StringUtil.getIp(request);
////					UserSession userSession = new UserSession();
////					userSession.setUser_id(sysUser.getId());
////					userSession.setUser_name(sysUser.getUsername());
////					userSession.setUser_id(sysUser.getId());
////					userSession.setUser_ip(ip);
////					userSession.setRealname(sysUser.getRealname());
////					userSession.setPhone(sysUser.getPhone());//电话
////					userSession.setRole_id(sysUser.getRole_id());
////
////					userSession.setDefault_module(sysUser.getDefault_module());// 默认模块
////					userSession.setDwid(sysUser.getDwid());// 单位id
////					SysDw sysDw = sysDwService.get(sysUser.getDwid());
////					if (sysDw != null) {
////						userSession.setDwjb(sysDw.getDwjb());// 单位级别
////						userSession.setDwmc(sysDw.getDwmc());// 单位名称
////						userSession.setDwlx(sysDw.getDwlx());// 单位类型
////						userSession.setDwsx(sysDw.getDwsx());// 单位属性
////						userSession.setDwfzr(sysDw.getDwfzr());//单位负责人
////					} else {
////						userSession.setDwjb("");
////						userSession.setDwmc("");// 单位名称
////						userSession.setDwlx("");// 单位类型
////						userSession.setDwsx("");// 单位属性
////						userSession.setDwfzr("");//单位负责人
////					}
////					request.getSession().setAttribute("userSession", userSession);
////
////					// 插入登录日志
////					SysUserLogin sysUserLogin = new SysUserLogin();
////					sysUserLogin.setUser_id(sysUser.getId());
////					sysUserLogin.setLogin_date(new Date());
////					sysUserLogin.setLogin_ip(ip);
////					sysUserLogin.setTerminal(WebUtil.getSafeStr(request.getParameter("terminal")));
////					sysUserLogin.setExplorerType(WebUtil.getSafeStr(request.getParameter("explorerType")));
////					sysUserLogin.setExplorerVersion(WebUtil.getSafeStr(request.getParameter("explorerVersion")));
////					sysUserLoginService.add(sysUserLogin);
////					WebUtil.out(response, JsonUtil.createOperaStr(true, "登录成功"));
////				}
////			}
////		}
////	}
////
////	/**
////	 * 进入首页面
////	 * @param request
////	 * @param response
////	 * @return
////	 */
////	@RequestMapping("/index")
////	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
////		ModelAndView mv = new ModelAndView();
////		UserSession userSession = SessionUtil.getUserSession(request);
////		if (userSession != null) {
////			mv.addObject("today", DateUtil.getSystemDate());
////			int onlineCount = OnLineListener.hashMap.size();
////			mv.addObject("onlineCount", onlineCount);// 在线人数
////			SysUser sysUser = sysUserService.get(userSession.getUser_id());
////			mv.addObject("status", sysUser.getStatus());// 状态
////			mv.setViewName("/index");
////		} else {
////			mv.setViewName("redirect:/login.do");
////		}
////		return mv;
////	}
////
////	/**
////	 *生成menu
////	 * @param request
////	 * @param response
////	 */
////	@RequestMapping("/createMenu")
////	public void createMenu(HttpServletRequest request, HttpServletResponse response) {
////		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
////		String json = sysUserService.createMenu(userSession.getRole_id());
////		WebUtil.out(response, json);
////	}
////
////	/**
////	 * 退出
////	 * @param request
////	 * @param response
////	 */
////	@RequestMapping("/logout")
////	public void logout(HttpServletRequest request, HttpServletResponse response) {
////		// request.getSession().removeAttribute("userSession");
////		request.getSession().invalidate();
////		WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
////	}
////
////	/**
////	 * 修改个人信息，登录页面
////	 */
////	@RequestMapping("/updateInfo")
////	public void updateInfo(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) {
////		String oldPass = WebUtil.getSafeStr(request.getParameter("oldPass"));
////		String newPass = WebUtil.getSafeStr(request.getParameter("newPass"));
////		int flag = sysUserService.updateInfo(sysUser, oldPass, newPass);
////		if (flag == 0)
////			WebUtil.out(response, JsonUtil.createOperaStr(false, "修改失败"));
////		else if (flag == 1)
////			WebUtil.out(response, JsonUtil.createOperaStr(true, "修改成功"));
////		else if (flag == 2)
////			WebUtil.out(response, JsonUtil.createOperaStr(false, "原密码输入错误"));
////	}
////
////	/**
////	 * 获取用户信息
////	 * @param request
////	 * @param response
////	 */
////	@RequestMapping("/getUserInfo")
////	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
////		UserSession userSession = SessionUtil.getUserSession(request);
////		// 获取用户信息
////		SysUser sysUser = sysUserService.get(userSession.getUser_id());
////		WebUtil.out(response, JsonUtil.toStr(sysUser));
////	}
//
//}
