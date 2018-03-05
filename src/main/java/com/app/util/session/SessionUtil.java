package com.app.util.session;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	/**
	 * 
	 * 功能描述:获取用户session
	 * 
	 * @param request
	 * @return UserSession
	 * @version 1.0.0
	 * @author 孔垂云
	 * @date 2016-12-06
	 */
	public static UserSession getUserSession(HttpServletRequest request) {
		if (request.getSession().getAttribute("userSession") != null)
			return (UserSession) request.getSession().getAttribute("userSession");
		else
			return null;
	}

	/**
	 * 
	 * 功能描述:获取登录用户的单位id，dwid
	 * 
	 * @param request
	 * @return int
	 * @version 1.0.0
	 * @author 孔垂云
	 * @date 2016-12-06
	 */
	public static int getDwid(HttpServletRequest request) {
		if (request.getSession().getAttribute("userSession") != null)
			return ((UserSession) request.getSession().getAttribute("userSession")).getDwid();
		else
			return 0;
	}

}
