package com.app.common.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.util.code.SerialNumUtil;
import com.app.util.date.DateUtil;
import com.app.util.web.WebUtil;

/**
 * 文件上传controller
 * 
 * @author chykong
 *
 */
@Controller
@RequestMapping("/common")
public class UploadController {
	public static final String upload_path = "D:/es/download/";

	@RequestMapping({ "upload" })
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("fileType") String fileType, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// String path =
		// request.getSession().getServletContext().getRealPath("/download") +
		// "\\" + fileType;
		// String path =
		// "G:/eclipse_es/eclipse/workspace/es/src/main/webapp/download/xl";
		String path = upload_path + fileType;
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		// String fileName = new Date().getTime()+".jpg";
		String createFilename = DateUtil.getShortSystemTime() + SerialNumUtil.createRandowmNum(6) + "." + suffix;
		File targetFile = new File(path, createFilename);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		String json = "";
		// 保存
		try {
			file.transferTo(targetFile);
			json = "{success:" + true + ",msgText:'" + "成功" + "',createFilename:'" + path + "/" + createFilename + "',old_filename:'" + fileName + "'}";
		} catch (Exception e) {
			json = "{success:" + false + ",msgText:'" + "上传失败" + "'}";
			e.printStackTrace();
		}
		WebUtil.out(response, json);
	}

}
