package com.app.userwork.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.UserSignDao;
import com.app.userwork.model.UserSign;
import com.app.util.date.DateUtil;

@Service
public class UserSignService {
	@Autowired
	private UserSignDao userSignDao;

	
	/**
	 * 签到
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 * @param user_id
	 * @return
	 */
	public int add(int user_id) {
		String startDate =""; //DateUtil.dateToString(new Date(), "yyyy-MM-dd");
		String endDate = "";//DateUtil.dateToString(new Date(), "yyyy-MM-dd");
		int listNum = userSignDao.list(startDate,endDate,user_id).size();
		if(listNum>0){
			return 0;
		}
		return userSignDao.add(user_id);
	}

	/**
	 * 签到列表
	 * @author 冉玉琦
	 * @date 2018年3月4日
	 * @param YearMonth
	 * @param user_id
	 * @return
	 */
	public List<UserSign> list(int year,int month,int user_id) {
		String startDate = DateUtil.getFirstDayOfMonth(year, month);
		String endDate = DateUtil.getLastDayOfMonth(year,month);
		List<UserSign> list = userSignDao.list(startDate,endDate,user_id);
		return list;
	}


}
