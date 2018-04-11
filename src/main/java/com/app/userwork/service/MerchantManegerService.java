package com.app.userwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.servicestop.model.UserDiscount;
import com.app.userwork.dao.MerchantManegerDao;
import com.app.userwork.model.MerchantDiscount;
import com.app.userwork.model.MerchantInfo;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

@Service
public class MerchantManegerService {
	@Autowired
	private MerchantManegerDao merchantManegerDao;

	/**
	 * 申請商家
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param merchantInfo
	 * @return
	 */
	public int add(MerchantInfo merchantInfo) {
		List<MerchantInfo> list = merchantManegerDao.getByUser_id(merchantInfo.getCreate_cd());
		if(list != null && list.size()>0){
			return 2;
		}
		String filepath = "";
			filepath = "merchant/evidence/"+merchantInfo.getCreate_cd();
		
		
		if(StringUtil.isNotNullOrEmpty(merchantInfo.getMerchant_img())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(merchantInfo.getMerchant_img(),filepath ,filename );
			if (flag) {
				merchantInfo.setMerchant_img(ConstantUtil.weburl+filepath+filename);
			}else {
				merchantInfo.setMerchant_img("");
			}
		}
		return merchantManegerDao.add(merchantInfo);
	}
	
	
	/**
	 * 发布优惠活动
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param merchantInfo
	 */

	public int addDiscount(MerchantDiscount merchantDiscount) {
		
		List<MerchantInfo> list = merchantManegerDao.getByUser_id(merchantDiscount.getCreate_cd());
		if(list == null || list.size()<0){
			return 0;
		}
		merchantDiscount.setMerchant_id(list.get(0).getMerchant_id());
		String filepath = "";
		filepath = "merchant/discount/"+merchantDiscount.getCreate_cd();
	
	
	if(StringUtil.isNotNullOrEmpty(merchantDiscount.getDiscount_img())){
		String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
		boolean flag = ImgFile.GenerateImage(merchantDiscount.getDiscount_img(),filepath ,filename );
		if (flag) {
			merchantDiscount.setDiscount_img(ConstantUtil.weburl+filepath+filename);
		}else {
			merchantDiscount.setDiscount_img("");
		}
	}
	return merchantManegerDao.addDiscount(merchantDiscount);
	}
	
	/**
	 * 商家活动查询
	 * @author 冉玉琦
	 * @date 2018年4月8日
	 * @param user_id
	 * @param type 1已发布 2 已使用
	 * @return
	 */


	public List<MerchantDiscount> list(String user_id,String type,int pageSize) {
		if(type == null){
			return null;
		}
		List<MerchantInfo> list = merchantManegerDao.getByUser_id(user_id);
		if(type.equals("1")){
			return merchantManegerDao.list1(list.get(0).getMerchant_id(),pageSize);
		}
		if(type.equals("2")){
			return merchantManegerDao.list2(list.get(0).getMerchant_id(),pageSize);
		}
		return null;
	}
	/**
	 * 商家活动使用情况查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public List<UserDiscount> listUse(int discount_id,int pageSize) {
		return merchantManegerDao.listUse(discount_id,pageSize);
	}
	/**
	 * 兑换优惠券
	 * @author 冉玉琦
	 * @date 2018年4月7日
	 * @param request
	 * @param response
	 * @param 
	 */
	public int addExchange(String user_id, String operation_no) {
		
		List<MerchantInfo> list = merchantManegerDao.getByUser_id(user_id);
		if(list == null || list.size()<0){
			return 2;
		}
		//商家id
		int Merchant_id = list.get(0).getMerchant_id();
		return merchantManegerDao.addExchange(user_id,Merchant_id,operation_no);
	}



	








	


	
	
}
