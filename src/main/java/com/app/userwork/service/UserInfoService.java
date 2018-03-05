package com.app.userwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.UserInfoDao;
import com.app.userwork.model.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	
	/**
	 * 获取用户信息  id
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param user_id
	 * @return
	 */
	public UserInfo userInfoList(int user_id) {
		return userInfoDao.userInfoForId(user_id);
	}

	/**
	 * 获取用户信息  username pwd
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param username
	 * @return
	 */
	public List<UserInfo> userInfoList(String username) {
		return userInfoDao.userInfoForName(username);
	}
	/**
	 * 保存用户信息
	 * @author 冉玉琦
	 * @date 2018年3月3日
	 * @param userInfo
	 * @return
	 */
	public UserInfo updateUserInfo(UserInfo userInfo) {
		return userInfoDao.updateUserInfo(userInfo);
		
	}
}
