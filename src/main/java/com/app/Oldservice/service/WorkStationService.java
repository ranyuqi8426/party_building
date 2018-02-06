package com.app.Oldservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.WorkStationDao;
import com.app.Oldservice.model.CreateParty;
import com.app.Oldservice.model.GoParty;
import com.app.Oldservice.model.WorkStation;


@Service
public class WorkStationService {
	@Autowired
	private WorkStationDao WorkStationeDao;
	public List<WorkStation> list(WorkStation WorkStation) {
		return WorkStationeDao.list(WorkStation);
	}
	/**
	 * 新建 我是党员/我要入党
	 * @param WorkStation
	 * @return
	 */
	public int addparty(GoParty GoParty) {
		GoParty.setCreate_date(new Date(new java.util.Date().getTime()));
		//待审核
		GoParty.setParty_status("1");
		return WorkStationeDao.addparty(GoParty);
	}
	/**
	 * 新建 成立党组织
	 * @param WorkStation
	 * @return
	 */
	public int addpartyteam(CreateParty CreateParty) {
		CreateParty.setCreate_date(new Date(new java.util.Date().getTime()));
		//待审核
		CreateParty.setParty_status("1");
		return WorkStationeDao.addpartyteam(CreateParty);
	}
	
	
}
