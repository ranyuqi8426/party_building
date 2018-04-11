package com.app.livecircle.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.livecircle.dao.ShowDao;
import com.app.livecircle.model.Show;
import com.app.livecircle.model.ShowLike;
import com.app.livecircle.model.ShowMessage;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

@Service
public class ShowService {
	@Autowired
	private ShowDao showDao;
	
	/**
	 * 晒晒列表查询
	 * @author 冉玉琦
	 * @date 2018年3月1日
	 */
	public List<Show> list(String user_id,int pageSize) {
		List<Show> list = showDao.list(user_id,pageSize);
		
		return list;
	}
	
	/**
	 * 点赞
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int addLike(int show_id,String user_id) {
		ShowLike showLike = new ShowLike();
		showLike.setCreate_cd(user_id);
		showLike.setShow_id(show_id);
		return showDao.addLike(showLike);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	public int deleteLike(int list_id,int user_id) {
		return showDao.deleteLike(list_id, user_id);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月22日
	 * @param showMessage
	 * @return
	 */
	public int addSay(ShowMessage showMessage) {
		return showDao.addSay(showMessage);
	}
	/**
	 * 新增
	 * @author 冉玉琦
	 * @date 2018年3月22日
	 * @param show
	 * @return
	 */
	public int add(Show show) {
		String filepath = "show/"+show.getCreate_cd();
		int imgNum = 0;
		if(StringUtil.isNotNullOrEmpty(show.getShow_img1())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(show.getShow_img1(),filepath ,filename );
			if (flag) {
				show.setShow_img1(ConstantUtil.weburl+filepath+filename);
			}else {
				show.setShow_img1("");
			}
			imgNum++;
		}
		if(StringUtil.isNotNullOrEmpty(show.getShow_img2())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(show.getShow_img2(),filepath ,filename );
			if (flag) {
				show.setShow_img2(ConstantUtil.weburl+filepath+filename);
			}else {
				show.setShow_img2("");
			}
			imgNum++;
		}
		if(StringUtil.isNotNullOrEmpty(show.getShow_img3())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(show.getShow_img3(),filepath ,filename );
			if (flag) {
				show.setShow_img3(ConstantUtil.weburl+filepath+filename);
			}else {
				show.setShow_img3("");
			}
			imgNum++;
		}
		show.setShow_num(String.valueOf(imgNum));
		//（1、创建成功2发布成功（审核））
		show.setShow_status("1");
		return showDao.add(show);
	}
	/**
	 * 我的  晒晒列表查询
	 * @param request
	 * @param response
	 */
	public List<Show> listMy(String user_id, int pageSize) {
		List<Show> list = showDao.listMy(user_id,pageSize);
		return list;
	}
	/**
	 * 我的  晒晒详情查询
	 * @param request
	 * @param response
	 */
	public Show getMy(String user_id, String show_id) {
		return showDao.getMy(user_id,show_id);
	}
}
