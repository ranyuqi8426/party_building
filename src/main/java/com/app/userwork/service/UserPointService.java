package com.app.userwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.userwork.dao.UserPointDao;
import com.app.userwork.model.UserPoint;
import com.app.userwork.model.UserPointRecord;

@Service
public class UserPointService {
	@Autowired
	private UserPointDao userPointDao;

	
	

	/**
	 * 积分列表
	 * @author 冉玉琦
	 * @date 2018年3月4日
	 * @param YearMonth
	 * @param user_id
	 * @return
	 */
	public List<UserPoint> listPoint() {
		List<UserPoint> list = userPointDao.listPoint();
		return list;
	}



	/**
	 * 个人积分
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public UserPoint get(int user_id) {
		return userPointDao.getPointForUserId(user_id);
	}



	/**
	 * 积分记录
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public List<UserPointRecord> list(int user_id) {
		return userPointDao.list(user_id);
	}
	/**
	 * 修改积分
	 * @author 冉玉琦
	 * @date 2018年3月23日
	 * @param user_id
	 * @return
	 */
	public int updatePoint(String user_id,int num) {
		UserPointRecord userPointRecord = new UserPointRecord();
		int falg = 0;
		// 获得方式（1签到2消费）
		if(num>0){
			falg = userPointDao.updateUserPoint(num,0,user_id);
			userPointRecord.setApply_phone("1");
		}else{
			falg = userPointDao.updateUserPoint(0,Math.abs(num),user_id);
			userPointRecord.setApply_phone("2");
		}
		if (falg == 1) {
			userPointRecord.setCreate_cd(user_id);
			// 获得积分（获得为+消费为-）
			userPointRecord.setApply_age(String.valueOf(num));
			return userPointDao.add(userPointRecord);
		}
		return 0;
	}

}
