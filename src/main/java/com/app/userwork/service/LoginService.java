package com.app.userwork.service;


import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.LoginDao;
import com.app.userwork.dao.UserInfoDao;
import com.app.userwork.model.BnsFloor;
import com.app.userwork.model.LoginLog;
import com.app.userwork.model.UserInfo;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserInfoDao userInfoDao;
	
	/**
	 * 普通登录 校验
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param username
	 * @param password
	 */
	public UserInfo checkLogin(String username, String password,String ip) {
		List<UserInfo> userinfolist = userInfoDao.userInfoForName(username);
		if(userinfolist !=null && userinfolist.size()>0){
			UserInfo UserInfo = userinfolist.get(0);
			if(UserInfo.getUser_password() != null && !UserInfo.getUser_password().equals("")){
				if (UserInfo.getUser_password().equals(password)) {
					//增加登录日志  1为普通登录
					addLoginLog(UserInfo.getUser_id(),ip,"1"); 
					return UserInfo;
					}
			}
		}
		return null;
	}
	/**
	 * 第三方登录
	 * @author 冉玉琦
	 * @date 2018年3月18日
	 * @param userInfo
	 * @param ip
	 * @return
	 */
	public UserInfo checkWXQQLogin(UserInfo userInfo, String ip,String LoginType) {
		List<UserInfo> userinfolist = userInfoDao.userInfoForOpenId(userInfo.getUser_tencent());
		UserInfo rtnUserInfo = new UserInfo();
		if(userinfolist !=null && userinfolist.size()>0){
			rtnUserInfo = userinfolist.get(0);
			rtnUserInfo.setHead_img_url(userInfo.getHead_img_url());
			rtnUserInfo.setUser_name(userInfo.getUser_name());
			rtnUserInfo.setSex(userInfo.getSex());
			rtnUserInfo.setHome_address(userInfo.getHome_address());
			rtnUserInfo.setUser_tencent(userInfo.getUser_tencent());
			userInfoDao.updateUserInfo(rtnUserInfo);
		}else {
			rtnUserInfo.setHead_img_url(userInfo.getHead_img_url());
			rtnUserInfo.setUser_name(userInfo.getUser_name());
			rtnUserInfo.setSex(userInfo.getSex());
			rtnUserInfo.setHome_address(userInfo.getHome_address());
			rtnUserInfo.setUser_tencent(userInfo.getUser_tencent());
			int user_id = loginDao.add(rtnUserInfo);
			rtnUserInfo.setUser_id(user_id);
		}
		//增加登录日志  
		addLoginLog(rtnUserInfo.getUser_id(),ip,LoginType); 
		return rtnUserInfo;
	}
	/**
	 * 插入交易日志
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param username
	 * @param password
	 */
	public void addLoginLog(int userId, String ip,String loginType) {
		LoginLog loginLog = new LoginLog();
		loginLog.setUser_id(String.valueOf(userId));
		loginLog.setUser_ip(ip);
		loginLog.setUserlogin_type(loginType);
		loginDao.addLoginLog(loginLog);
	}
	/**
	 * 获取楼宇列表
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @return
	 */
	public List<BnsFloor> queryFloorList() {
		return loginDao.queryFloorList();
	}
	/**
	 * 注册
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param user_cd
	 * @param user_password
	 * @return
	 */
	public int add(String user_cd, String user_password) {
		List<UserInfo> userinfolist = userInfoDao.userInfoForName(user_cd);
		if(userinfolist !=null){
			return 2;
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_cd(user_cd);
		userInfo.setUser_password(user_password);
		userInfo.setPhone(user_cd);
		if(loginDao.add(userInfo)>0){
			return 1;
		}
		return 0;
	}
	
}
