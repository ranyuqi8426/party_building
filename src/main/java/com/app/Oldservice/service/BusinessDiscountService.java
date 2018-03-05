package com.app.Oldservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Oldservice.dao.BusinessDiscountDao;
import com.app.Oldservice.model.Business;
import com.app.Oldservice.vo.BusinessDiscountVO;

@Service
public class BusinessDiscountService {
	@Autowired
	private BusinessDiscountDao BusinessDiscountDao;
	/**
	 * 总数
	 */
	public int listCount(BusinessDiscountVO BusinessDiscountVO) {
		return BusinessDiscountDao.listCount(BusinessDiscountVO);
	} 
	/**
	 * 新增
	 */
	public int add(Business Business) {
		return BusinessDiscountDao.add(Business);
	}
	/**
	 * 修改
	 */
	public int update(Business Business) {
		return BusinessDiscountDao.update(Business);
	}
	/**
	 * 列表
	 */
	public List<Business> list(BusinessDiscountVO BusinessDiscountVO) {
		List<Business> list = BusinessDiscountDao.list(BusinessDiscountVO);
		return list;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int learning_data_id) {
		return BusinessDiscountDao.delete(learning_data_id);
	}
}
