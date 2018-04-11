package com.app.livecircle.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.livecircle.dao.WishDao;
import com.app.livecircle.model.Wish;
import com.app.livecircle.model.WishStatus;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

@Service
public class WishService {
	@Autowired
	private WishDao wishDao;
	
	/**
	 * 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Wish> list(String wish_type,int pageSize) {
		List<Wish> list = wishDao.list(wish_type,pageSize);
		
		return list;
	}
	/**
	 * 心愿详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public Wish get(String list_id) {
		Wish information = wishDao.get(list_id);
		
		return information;
	}
	/**
	 * 心愿状态详情
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<WishStatus> getWishStatus(String list_id) {
		
		return wishDao.getWishStatus(list_id);
	}
	
	/**
	 * 新建心愿
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int add(Wish wish) {
		//心愿状态（0、未认领 1、已认领）
		wish.setWish_type("0");
		String filepath = "wish/"+wish.getCreate_cd();
		int imgNum = 0;
		if(StringUtil.isNotNullOrEmpty(wish.getWish_img1())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(wish.getWish_img1(),filepath ,filename );
			if (flag) {
				wish.setWish_img1(ConstantUtil.weburl+filepath+filename);
			}else {
				wish.setWish_img1("");
			}
			imgNum++;
		}
		if(StringUtil.isNotNullOrEmpty(wish.getWish_img2())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(wish.getWish_img2(),filepath ,filename );
			if (flag) {
				wish.setWish_img2(ConstantUtil.weburl+filepath+filename);
			}else {
				wish.setWish_img2("");
			}
			imgNum++;
		}
		if(StringUtil.isNotNullOrEmpty(wish.getWish_img3())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(wish.getWish_img3(),filepath ,filename );
			if (flag) {
				wish.setWish_img3(ConstantUtil.weburl+filepath+filename);
			}else {
				wish.setWish_img3("");
			}
			imgNum++;
		}
		wish.setWish_imgnum(String.valueOf(imgNum));
		
		int wish_id = wishDao.add(wish);
		if(wish_id != 0){
			WishStatus wishStatus = new WishStatus();
			wishStatus.setWish_id(wish_id);
			//心愿状态（每个心愿对应此表四条状态记录。1创建2审核通过3不通过4完成）
			wishStatus.setWish_status_nm("1");
			wishStatus.setCreate_cd(wish.getCreate_cd());
			return wishDao.addWishStatus(wishStatus);
		}
		return 0;
		
	}
	/**
	 * 认领心愿
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param wishStatus
	 * @return
	 */
	public int update(WishStatus wishStatus) {
		int flag = wishDao.update(wishStatus.getWish_id());
		if(flag == 1){
			wishStatus.setWish_status_nm("4");
			return wishDao.addWishStatus(wishStatus);
		}
		return 0;
	}
	/**
	 * 我的 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * wish_status_nm（wish_status_nm） 1创建（发布）   2审核3审核不通过   4完成(认领)
	 * @return
	 */
	public List<Wish> listMy(String user_id,String wish_status_nm,int pageSize) {
		return wishDao.listMy(user_id, wish_status_nm, pageSize);
	}
	
}
