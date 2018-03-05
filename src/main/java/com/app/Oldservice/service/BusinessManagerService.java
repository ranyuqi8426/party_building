package com.app.Oldservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.BusinessManagerDao;
import com.app.Oldservice.model.DataBiz;
import com.app.Oldservice.vo.BusinessManagerVO;

@Service
public class BusinessManagerService {
	@Autowired
	private BusinessManagerDao BusinessManagerDao;
	/**
	 * 总数
	 */
	public int listCount(BusinessManagerVO BusinessManagerVO) {
		return BusinessManagerDao.listCount(BusinessManagerVO);
	} 
	/**
	 * 新增
	 */
	public int add(DataBiz DataBiz) {
		return BusinessManagerDao.add(DataBiz);
	}
	/**
	 * 修改
	 */
	public int update(DataBiz DataBiz) {
		return BusinessManagerDao.update(DataBiz);
	}
	/**
	 * 列表
	 */
	public List<DataBiz> list(BusinessManagerVO BusinessManagerVO) {
		List<DataBiz> list = BusinessManagerDao.list(BusinessManagerVO);
		return list;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int learning_data_id) {
		return BusinessManagerDao.delete(learning_data_id);
	}
	/**
	 * 获取商户信息
	 */
	public DataBiz getOne(int user_id) {
		return BusinessManagerDao.getOne(user_id);
		
	}
}
