package com.app.OldpartyLecture.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.OldpartyLecture.dao.VideoManagerPCDao;
import com.app.OldpartyLecture.model.DataManagerPC;
import com.app.OldpartyLecture.vo.DataManagerPCVO;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

@Service
public class BookManagerPCService {
	@Autowired
	private VideoManagerPCDao videoManagerPCDao;
	private static String imgpath = "E:/resourcesfile/images/partyLectureVideoImg";
	private static String videopath = "E:/resourcesfile/video";
	/**
	 * 总数
	 */
	public int listCount(DataManagerPCVO dataManagerPCVO) {
		return videoManagerPCDao.listCount(dataManagerPCVO);
	} 
	/**
	 * 新增
	 */
	public int add(DataManagerPC dataManagerPC) {
		if(dataManagerPC.getLearning_data()!=null&&dataManagerPC.getLearning_pic()!=null){
			String dateStr = DateUtil.getShortSystemTime();
			String filepath = "";
			String filename = "/"+dateStr+".mp4";
			boolean flag = ImgFile.GenerateVideoForFile(dataManagerPC.getLearning_data(),filepath ,filename );
			if (flag) {
				dataManagerPC.setLearning_data_url(ConstantUtil.weburl+filepath+filename);
			}else {
				dataManagerPC.setLearning_data_url("");
			}
			
			String fileimgpath = "partyLectureVideoImg";
			String fileimgname = "/"+dateStr+".jpg";
			boolean flagimg = ImgFile.GenerateImageForFile(dataManagerPC.getLearning_pic(),fileimgpath ,fileimgname );
			if (flagimg) {
				dataManagerPC.setLearning_pic_url(ConstantUtil.weburl+filepath+filename);
			}else {
				dataManagerPC.setLearning_pic_url("");
			}
		}
		dataManagerPC.setCreate_date(new Date(new java.util.Date().getTime()));
		//1、视频
		dataManagerPC.setLearning_data_type("1");
		return videoManagerPCDao.add(dataManagerPC);
	}
	/**
	 * 修改
	 */
//	public int update(DataManagerPC dataManagerPC) {
//		return videoManagerPCDao.update(dataManagerPC);
//	}
	/**
	 * 列表
	 */
	public List<DataManagerPC> list(DataManagerPCVO dataManagerPCVO) {
		return videoManagerPCDao.list(dataManagerPCVO);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int learning_data_id) {
		DataManagerPC dataManagerPC = videoManagerPCDao.get(learning_data_id);
		int flag = videoManagerPCDao.delete(learning_data_id);
		//删除文件
		if(flag == 1){
			String Learning_data_url = dataManagerPC.getLearning_data_url();
			if(StringUtil.isNotNullOrEmpty(Learning_data_url)){
				ImgFile.deleteFile(videopath+Learning_data_url.substring(Learning_data_url.lastIndexOf("/")));
			}
			String Learning_pic_url = dataManagerPC.getLearning_pic_url();
			if (StringUtil.isNotNullOrEmpty(Learning_pic_url)) {
				ImgFile.deleteFile(imgpath+Learning_pic_url.substring(Learning_pic_url.lastIndexOf("/")));
			}
			
		}
		
		return flag;
	}
}
