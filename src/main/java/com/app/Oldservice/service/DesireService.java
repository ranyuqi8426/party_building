package com.app.Oldservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.DesireDao;
import com.app.Oldservice.model.Desire;
import com.app.Oldservice.model.User;
import com.app.Oldservice.vo.DesireVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;

@Service
public class DesireService {
	@Autowired
	private DesireDao desireDao;
	
	public List<Desire> list(DesireVO desireVO) {
		//审核必须通过
		desireVO.setAudit_status("1");
		List<Desire> list = desireDao.list(desireVO);
		for(Desire one : list) {
			List<User> listBiz = desireDao.getUserName(one.getUser_id());
			String userName = listBiz.get(0).getUsername();
			one.setUserName(userName);
			if ("1".equals(one.getStatus())) {
				List<User> listBiz1 = desireDao.getUserName(one.getFinish_id());
				String finishName = listBiz1.get(0).getUsername();
				one.setFinish_name(finishName);
			}
		}
		return list;
	}
	
	public List<Desire> getOne(String want_id) {
		return desireDao.getOne(want_id);
	}
	
	public int add(Desire desire) {
		//0 未审核 1 审核通过 2审核未通过
		desire.setAudit_status("0");
		//0未完成 1已完成
		desire.setStatus("0");
		//初始化 未领取人为0
		desire.setFinish_id(0);
		//初始化 没有照片为0
		desire.setPicture_id(0);
		//初始化  没有审核人为0
//		desire.setAuditor_id(0);
		desire.setCreate_time(new Date());
		String filepath = "Desire/"+desire.getUser_id();
		String filename = "/"+DateUtil.getShortSystemTime()+".jpg";
		boolean flag = ImgFile.GenerateImage(desire.getPic_url1(),filepath ,filename );
		if (flag) {
			desire.setPic_url1(ConstantUtil.weburl+filepath+filename);
		}else {
			desire.setPic_url1("");
		}		
		
		
		return desireDao.get(desire);
	}



	public int updateFinish(DesireVO desireVO) {
		List<Desire> listBiz = desireDao.getOne(Integer.toString(desireVO.getWant_id()));
		int user_id = listBiz.get(0).getUser_id();
		int finish_id = desireVO.getUser_id();
		if(user_id == finish_id) {
			return 3;
		}else {
			desireVO.setFinish_id(finish_id);
			desireVO.setStatus("1");
			return desireDao.updateFinish(desireVO);
		}
		
	}

}
