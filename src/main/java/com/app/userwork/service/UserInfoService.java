package com.app.userwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.UserInfoDao;
import com.app.userwork.model.UserInfo;
import com.app.userwork.vo.UserInfoVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

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
		String filepath = "userInfo/"+userInfo.getUser_id();
		if(StringUtil.isNotNullOrEmpty(userInfo.getHead_img_url())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(userInfo.getHead_img_url(),filepath ,filename );
			if (flag) {
				userInfo.setHead_img_url(ConstantUtil.weburl+filepath+filename);
			}else {
				userInfo.setHead_img_url("");
			}
		}
		return userInfoDao.updateUserInfo(userInfo);
		
	}

	public int updatePWD(UserInfoVO userInfo) {
		return userInfoDao.updatePWD(userInfo);
	}
}
