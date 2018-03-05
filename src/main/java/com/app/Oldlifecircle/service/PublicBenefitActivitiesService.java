package com.app.Oldlifecircle.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlifecircle.dao.PublicBenefitActivitiesDao;
import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlifecircle.model.UserActivity;
import com.app.Oldlifecircle.vo.HappyPartyVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
@Service
public class PublicBenefitActivitiesService {

	@Autowired
	private PublicBenefitActivitiesDao publicBenefitActivitiesDao;
	

	public List<HappyParty> list(HappyPartyVO HappyPartyVO) {
		return publicBenefitActivitiesDao.list(HappyPartyVO);
	}
	public HashMap<String,Object> meList(HappyPartyVO HappyPartyVO) {
		return publicBenefitActivitiesDao.listMe(HappyPartyVO);
	}
	public List<HappyParty> get(String id,String uid) {
		return publicBenefitActivitiesDao.get(id,uid);
	}
	public int  addUserActivity(int id ,int User_id) {
		UserActivity userActivity = new UserActivity();
		userActivity.setActivity_id(id);
		// 公益活动
		userActivity.setActivity_type("2");
		userActivity.setUser_id(User_id);
		//参与者
		userActivity.setUser_type("2");
		return publicBenefitActivitiesDao.addUserActivity(userActivity);
	}
	/**
	 * 新增
	 */
	public int add(HappyParty HappyParty) {
		String filepath = "PublicBenefitActivities/"+HappyParty.getUser_id();
		String filename = "/"+DateUtil.getShortSystemTime()+".jpg";
		
		boolean flag = ImgFile.GenerateImage(HappyParty.getImg_url(),filepath ,filename );
		if (flag) {
			HappyParty.setImg_url(ConstantUtil.weburl+filepath+filename);
		}else {
			HappyParty.setImg_url("");
		}
		HappyParty.setAudit_status("2");
		HappyParty.setNumber_real(1);
		HappyParty.setType("2");
		if (new Date().getTime() <DateUtil.stringToDate(HappyParty.getBegin_time(), "yyyy-MM-dd") .getTime()) {
			HappyParty.setStatue("1");
		} else if (new Date().getTime() >DateUtil.stringToDate(HappyParty.getEnd_time(), "yyyy-MM-dd").getTime()) {
			HappyParty.setStatue("2");
		} else {
			HappyParty.setStatue("4");
		}

		return publicBenefitActivitiesDao.add(HappyParty);
	}

}
