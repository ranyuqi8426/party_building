package com.app.servicestop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.servicestop.dao.PolicyDao;
import com.app.servicestop.model.Policy;

@Service
public class PolicyService {
	@Autowired
	private PolicyDao policyDao;
	
	/**
	 * 政策发布列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Policy> list(String floorid,String policy_type,int pageSize) {
		List<Policy> list = policyDao.list(floorid,policy_type,pageSize);
		
		return list;
	}

	public Policy get(String list_id) {
		return  policyDao.get(list_id);
	}
	
}
