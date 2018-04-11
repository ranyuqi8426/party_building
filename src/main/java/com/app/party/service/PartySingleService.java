package com.app.party.service;

import com.app.party.dao.PartySingleDao;
import com.app.party.model.PartySingle;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.file.ImgFile;
import com.app.util.string.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiNan on 2018-03-07.
 * Description:
 */
@Service
public class PartySingleService {
    @Autowired
    private PartySingleDao partySingleDao;
    
    public List<PartySingle> list(String build_id, String user_id, String content_type,String party_single_status) {
        return partySingleDao.list(build_id,user_id,content_type,party_single_status);
    }

    public PartySingle getOne(String partySinge_id, String content_type) {
        return partySingleDao.getOne(partySinge_id,content_type);
    }

    public int add(PartySingle partySingle) {
    	partySingle.setStatus("1");
    	String filepath = "";
    	String content_type = partySingle.getContent_type();
    	if(content_type != null && content_type.equals("1")){
    		filepath = "GFJS/"+partySingle.getCreate_cd();
    	}else if (content_type != null && content_type.equals("2")) {
    		filepath = "LXFW/"+partySingle.getCreate_cd();
		} else {
			filepath = "ZZFG/"+partySingle.getCreate_cd();
		}
		
		
		if(StringUtil.isNotNullOrEmpty(partySingle.getContent_img())){
			String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
			boolean flag = ImgFile.GenerateImage(partySingle.getContent_img(),filepath ,filename );
			if (flag) {
				partySingle.setContent_img(ConstantUtil.weburl+filepath+filename);
			}else {
				partySingle.setContent_img("");
			}
		}
		if(StringUtil.isNotNullOrEmpty(partySingle.getImg1())){
			String filename1 = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+"1.jpg";
			boolean flag1 = ImgFile.GenerateImage(partySingle.getImg1(),filepath ,filename1 );
			if (flag1) {
				partySingle.setImg1(ConstantUtil.weburl+filepath+filename1);
			}else {
				partySingle.setImg1("");
			}
		}
		if(StringUtil.isNotNullOrEmpty(partySingle.getImg2())){
			String filename2 = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+"2.jpg";
			boolean flag2 = ImgFile.GenerateImage(partySingle.getImg2(),filepath ,filename2 );
			if (flag2) {
				partySingle.setImg2(ConstantUtil.weburl+filepath+filename2);
			}else {
				partySingle.setImg2("");
			}
		}
		if(StringUtil.isNotNullOrEmpty(partySingle.getImg3())){
			String filename3 = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+"3.jpg";
			boolean flag3 = ImgFile.GenerateImage(partySingle.getImg3(),filepath ,filename3 );
			if (flag3) {
				partySingle.setImg3(ConstantUtil.weburl+filepath+filename3);
			}else {
				partySingle.setImg3("");
			}
		}
		if(StringUtil.isNotNullOrEmpty(partySingle.getImg4())){
			String filename4 = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+"4.jpg";
			boolean flag4 = ImgFile.GenerateImage(partySingle.getImg4(),filepath ,filename4 );
			if (flag4) {
				partySingle.setImg4(ConstantUtil.weburl+filepath+filename4);
			}else {
				partySingle.setImg4("");
			}
		}
		if(StringUtil.isNotNullOrEmpty(partySingle.getImg5())){
			String filename5 = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+"5.jpg";
			boolean flag5 = ImgFile.GenerateImage(partySingle.getImg5(),filepath ,filename5 );
			if (flag5) {
				partySingle.setImg5(ConstantUtil.weburl+filepath+filename5);
			}else {
				partySingle.setImg5("");
			}
		}
		
		
		
		
        return partySingleDao.add(partySingle);
    }

    public int update(PartySingle partySingle) {
        return partySingleDao.update(partySingle);
    }

    public int delete(String party_single_id) {
        return partySingleDao.delete(party_single_id);
    }
}
