package com.app.Oldmy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.Oldlogin.model.SysLogin;
import com.app.Oldmy.dao.UserInfoMargerDao;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
@Service
public class UserInfoMargerService {

	@Autowired
	private UserInfoMargerDao UserInfoMargerDao;
	/**
	 * 修改头像
	 */
	public String updateHearUrl(String user_id,MultipartFile HearImg) {
		String filepath = "UserHear/"+user_id;
		String filename = "/"+DateUtil.getShortSystemTime()+".jpg";
		String HearUrl ="";
		if (HearImg !=null) {
			boolean flag =ImgFile.GenerateImageForFile(HearImg, filepath, filename);
			if (flag) {
				HearUrl = ConstantUtil.weburl+filepath+filename;
			}
		}
		if (UserInfoMargerDao.updateHearUrl(user_id,HearUrl)==1) {
			return HearUrl;
		}
		return null;
	}
	/**
	 * 修改用户信息
	 */
	public int updateUserInfo(SysLogin SysLogin){
		return UserInfoMargerDao.updateUserInfo(SysLogin);
	}
	/**
	 * 获取用户信息
	 */
	public List<SysLogin> getUserInfo(SysLogin SysLogin){
		return UserInfoMargerDao.getUserInfo(SysLogin);
	}
}
