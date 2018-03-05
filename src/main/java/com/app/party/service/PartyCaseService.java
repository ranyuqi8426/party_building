package com.app.party.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.party.dao.PartyCaseDao;
import com.app.party.model.PartyCase;

@Service
public class PartyCaseService {
	@Autowired
	private PartyCaseDao partyCaseDao;
	
	/**
	 * 身边榜样列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<PartyCase> list(String floorid ,int pageSize,String isDop) {
		List<PartyCase> list = partyCaseDao.list(floorid,pageSize,isDop);
		
		return list;
	}
	/**
	 * 身边榜样详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public PartyCase get(String list_id) {
		PartyCase information = partyCaseDao.get(list_id);
		
		return information;
	}
	
	
}
