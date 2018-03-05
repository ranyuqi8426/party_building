package com.app.Oldlogin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldlogin.dao.LodSysLoginDao;
import com.app.Oldlogin.dao.SysSignLog;
import com.app.Oldlogin.model.PointLog;
import com.app.Oldlogin.model.SysLogin;
import com.app.Oldlogin.model.SysPoint;
import com.app.Oldlogin.model.SysSign;
import com.app.Oldlogin.vo.SysLoginVO;
import com.app.util.date.DateUtil;
import com.app.util.point.PointUtil;

@Service
public class SysLoginService {

	@Autowired
	private LodSysLoginDao sysLoginDao;

	public List<SysLogin> list(SysLoginVO sysLoginVO) {
		return sysLoginDao.list(sysLoginVO);
	}
	public List<PointLog> getPointLog(String user_id) {
		return sysLoginDao.getPointLog(user_id);
	}
	public List<SysPoint> getPoint(String user_id) {
		return sysLoginDao.getPoint(user_id);
	}
	/**
	 * 新增
	 */
	public int add(SysLogin sysLogin) {
		// 正常
		sysLogin.setStatus("0");
		if (sysLogin.getIs_mobile_user() == 1) {
			// 手机普通用户
			sysLogin.setRole_id(1);
		}
		sysLogin.setCreatetime(new java.sql.Date(new java.util.Date().getTime()));

		// 校验验证码

		return sysLoginDao.add(sysLogin);
	}
	/**
	 * 获取签到记录
	 */
	public List<SysSignLog> getSignLog(int user_id,int year,int month) {
		List<SysSignLog> list = sysLoginDao.getSignPartLog(user_id,DateUtil.yearMonthFormatTop(year,month),DateUtil.yearMonthFormatNext(year,month));
		return list;
	}
	/**
	 * 查询是否签到
	 * @param user_id
	 * @return 0 已签到
	 * 1 未签到
	 * */
	public int querySign(int user_id) {
		List<SysSignLog> list = sysLoginDao.getSignLog(user_id);
		int flag  = 0;
		if (list != null && list.size()>0) {
			SysSignLog sysSignLog = list.get(0);
			System.out.println(sysSignLog.getLogin_time());
			flag = DateUtil.checkSignDate(sysSignLog.getLogin_time());
		}else {
			flag = 1;
		}
		return flag;
	}
	/**
	 * 签到
	 */
	public List<SysSign> addSign(int user_id) {
		SysSignLog sysSignLog = new SysSignLog();
		sysSignLog.setLogin_time(new java.sql.Date(new java.util.Date().getTime()));
		sysSignLog.setUser_id(user_id);
		int flag = sysLoginDao.addSign(sysSignLog);
		// 更新签到表
		if (flag != 0 ) {
			List<SysSign> list = sysLoginDao.getSignRecord(sysSignLog.getUser_id());
			SysSign sysSign = new SysSign();
			if (list != null && list.size() == 1) {
				//首次签到
				if (list.get(0).getLast_login_date() == null) {
					sysSign.setLast_login_date(new Date(new Date().getTime()));
					sysSign.setTotal_times(1);
					sysSign.setContinue_times(1);
					//连续签到
				} else if (DateUtil.datePK(list.get(0).getLast_login_date())) {
					sysSign.setLast_login_date(new Date(new Date().getTime()));
					sysSign.setTotal_times(list.get(0).getTotal_times() + 1);
					sysSign.setContinue_times(list.get(0).getContinue_times() + 1);
				} else {
					//不连续签到
					sysSign.setLast_login_date(new Date(new Date().getTime()));
					sysSign.setTotal_times(list.get(0).getTotal_times() + 1);
					sysSign.setContinue_times(1);
				}
				sysSign.setUser_id(sysSignLog.getUser_id());
				//修改签到总记录
				int flag2 = sysLoginDao.updateSign(sysSign);
				//签到增加积分
				if (flag2 == 1) {
					List<SysSign> list2 = new ArrayList<SysSign>();
					list2.add(sysSign);
					int num = PointUtil.getPointNum("1");
					PointLog pointLog = new PointLog();
					pointLog.setCreate_date(new java.sql.Date(new java.util.Date().getTime()));
					pointLog.setPoint_num(num);
					//签到
					pointLog.setPoint_type("4");
					pointLog.setUser_id(user_id);
					sysLoginDao.addPointLog(pointLog);
					return list2;
				}
			}
		}
		return null;
	}
	// public List<SysLogin> get(String user_id) {
	// return sysLoginDao.get(user_id);
	// }

}
