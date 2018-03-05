package com.app.Oldlifecircle.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.dao.HappyPartyDao;
import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlifecircle.model.UserActivity;
import com.app.Oldlifecircle.vo.HappyPartyVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
@Service
public class HappyPartyService {

	@Autowired
	private HappyPartyDao happyPartyDao;
	public List<HappyParty> list(HappyPartyVO HappyPartyVO) {
		return happyPartyDao.list(HappyPartyVO);
	}
	public HashMap<String,Object> listMe(HappyPartyVO HappyPartyVO) {
		return happyPartyDao.listMe(HappyPartyVO);
	}
	public List<HappyParty> get(String id,String uid) {
		return happyPartyDao.get(id,uid);
	}
	public int  addUserActivity(int id ,int User_id) {
		UserActivity userActivity = new UserActivity();
		userActivity.setActivity_id(id);
		// 社团活动
		userActivity.setActivity_type("1");
		userActivity.setUser_id(User_id);
		//参与者
		userActivity.setUser_type("2");
		return happyPartyDao.addUserActivity(userActivity);
	}
	/**
	 * 新增
	 */
	public int add(HappyParty HappyParty) {
		HappyParty.setAudit_status("2");
		String filepath = "HappyParty/"+HappyParty.getUser_id();
		String filename = "/"+DateUtil.getShortSystemTime()+".jpg";
		boolean flag = ImgFile.GenerateImage(HappyParty.getImg_url(),filepath ,filename );
		if (flag) {
			HappyParty.setImg_url(ConstantUtil.weburl+filepath+filename);
		}else {
			HappyParty.setImg_url("");
		}
		HappyParty.setNumber_real(1);
		HappyParty.setType("1");
		if (new Date().getTime() <DateUtil.stringToDate(HappyParty.getBegin_time(), "yyyy-MM-dd") .getTime()) {
			HappyParty.setStatue("1");
		} else if (new Date().getTime() >DateUtil.stringToDate(HappyParty.getEnd_time(), "yyyy-MM-dd").getTime()) {
			HappyParty.setStatue("2");
		} else {
			HappyParty.setStatue("4");
		}

		return happyPartyDao.add(HappyParty);
	}

//	/**
//	 * 修改
//	 */
//	public int update(HappyParty HappyParty) {
//		return happyPartyDao.update(HappyParty);
//	}
//
//	/**
//	 * 删除
//	 */
//	public int delete(String account_id) {
//		return happyPartyDao.delete(account_id);
//	}
}
