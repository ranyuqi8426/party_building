package com.app.party.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.party.dao.PartyMoneyDao;
import com.app.party.model.PartyMoney;

@Service
public class PartyMoneyService {
	@Autowired
	private PartyMoneyDao partyMoneyDao;
	
	/**
	 * 党费缴纳列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<PartyMoney> list(String floor_id,String user_id) {
		List<PartyMoney> list = partyMoneyDao.list(floor_id,user_id);
		
		return list;
	}
	/**
	 * 党费缴纳
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(PartyMoney partyMoney) {
		return partyMoneyDao.add(partyMoney);
	}
	
	
}
