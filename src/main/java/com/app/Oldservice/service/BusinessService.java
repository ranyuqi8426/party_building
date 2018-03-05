package com.app.Oldservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.BussinessDao;
import com.app.Oldservice.model.Business;
import com.app.Oldservice.model.DataBiz;
import com.app.Oldservice.model.UserBiz;
import com.app.Oldservice.vo.BusinessVO;

@Service
public class BusinessService {

	@Autowired
	private BussinessDao bussinessDao;
	
	public List<Business> list(BusinessVO businessVO) {
		//优惠券未过期
		businessVO.setEndTime(new Date());
		List<Business> list = bussinessDao.list(businessVO);
		for(Business one : list) {
			List<DataBiz> listBiz = bussinessDao.getOne(one.getBiz_id());
			String bizName = listBiz.get(0).getName();
			one.setBiz_name(bizName);
		}
		return list;
	}

	public int add(UserBiz userBiz) {
		int a = bussinessDao.getOne(userBiz);
		if(a == 1) {
			return bussinessDao.add(userBiz);
		}else {
			return a;
		}
		
	}
	public HashMap<String,Object> listMe(BusinessVO businessVO) {
		return bussinessDao.listMe(businessVO);
	}
	public int update(String id) {
		int a = bussinessDao.update(id);
		return a;
		
	}
	public int delete(String id) {
		int a = bussinessDao.delete(id);
		return a;
		}
		
	}

