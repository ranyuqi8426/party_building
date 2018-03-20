package com.app.servicestop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.servicestop.dao.DiscountDao;
import com.app.servicestop.model.Discount;
import com.app.servicestop.model.UserDiscount;
import com.app.userwork.dao.UserPointDao;
import com.app.userwork.model.UserPoint;
import com.app.util.date.DateUtil;
import com.app.util.string.StringUtil;

@Service
public class DiscountService {
	@Autowired
	private DiscountDao discountDao;
	@Autowired
	private UserPointDao userPointDao;
	
	/**
	 * 优惠列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Discount> list(String floor_id,int pageSize) {
		List<Discount> list = discountDao.list(floor_id,pageSize);
		
		return list;
	}
	
	/**
	 * 领取优惠
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public int add(Discount discount) {
		List<UserDiscount> list = discountDao.listUser(discount.getMerchant_discount_id());
		if(list == null || discount.getDiscount_num() == null){
			return 0;
		}
		if(discount.getDiscount_num()<=list.size()){
			return 1;
		}
		for (int i = 0; i < list.size(); i++) {
			if(discount.getMerchant_id() == list.get(i).getUser_id()){
				return 2;
			}
		}
		UserPoint userPoint = userPointDao.getPointForUserId(discount.getMerchant_id());
		if(userPoint == null ){
			return 0;
		}
		if((Integer.parseInt(userPoint.getAdd_point())-Integer.parseInt(userPoint.getReduce_point()))<Integer.valueOf(discount.getDiscount_fraction())){
			return 3;
		}
		UserDiscount userDiscount = new UserDiscount();
		userDiscount.setUser_id(discount.getMerchant_id());
		userDiscount.setDiscount_id(discount.getMerchant_discount_id());
		userDiscount.setOperation_no(StringUtil.getItemID(4)+DateUtil.getShortSystemTime()+discount.getMerchant_id());// 兑换码
		userDiscount.setOperation_status("0");// 兑换状态 0未兑换1已兑换
		discountDao.add(userDiscount);
		return 6;
	}
	/**
	 * 优惠劵查询
	 * @author 冉玉琦
	 * @date 2018年3月19日
	 * @param ask_answer_id
	 * @return
	 */
	public Discount get(int merchant_discount_id) {
		return discountDao.get(merchant_discount_id);
	}
	
	
}
