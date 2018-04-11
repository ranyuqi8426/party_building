package com.app.util.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.Constants;
import com.app.util.constant.ConstantUtil;
import com.app.util.date.DateUtil;
import com.app.util.string.StringUtil;

import Decoder.BASE64Decoder;

public class ImgFile {
	private static String publicpath = "E:/resourcesfile/images/";
	private static String videopath = "E:/resourcesfile/video/";
	/**
	 *  生成视频
	 * @param video 视频
	 * @param filepath 目录
	 * @param filename 图片名
	 * @return
	 */
	public static boolean GenerateVideoForFile(MultipartFile video, String filepath, String filename) { // 对字节数组字符串进行Base64解码并生成图片
		try {
			// Base64解码
			byte[] b = video.getBytes();
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成视频
			String videoFilePath = ImgFile.createDir(videopath+filepath, filename);
			OutputStream out = new FileOutputStream(videoFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 *  base64字符串转化成图片
	 * @param img 图片
	 * @param filepath 目录
	 * @param filename 图片名
	 * @return
	 */
	public static boolean GenerateImageForFile(MultipartFile img, String filepath, String filename) { // 对字节数组字符串进行Base64解码并生成图片
		try {
			// Base64解码
			byte[] b = img.getBytes();
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = ImgFile.createDir(publicpath+filepath, filename);// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 *  base64字符串转化成图片  上传ftp
	 * @param img 图片
	 * @param filepath 目录
	 * @param filename 图片名
	 * @return
	 */
	public static boolean GenerateImage(String img, String filepath, String filename) { // 对字节数组字符串进行Base64解码并生成图片
		if (img == null||img.equals("")) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(img);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			filepath = ConstantUtil.projectName+filepath;
			filename = filename.replaceAll("/", "");
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			String pathUrl = FileUploadUtil.uploadFile(filename,bais,filepath);
			if (StringUtil.isNotNullOrEmpty(pathUrl)) {
				return true;
			}
			return false;
			
		} catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {
		String img= "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";
		String filename = "/"+StringUtil.creadImgName(DateUtil.getShortSystemTime())+".jpg";
		GenerateImage(img, "shows/1", filename);
	}
	/**
	 *  base64字符串转化成图片
	 * @param img 图片
	 * @param filepath 目录
	 * @param filename 图片名
	 * @return
	 */
	public static boolean GenerateImage2(String img, String filepath, String filename) { // 对字节数组字符串进行Base64解码并生成图片
		if (img == null||img.equals("")) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(img);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = ImgFile.createDir(publicpath+filepath, filename);// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * 创建文件夹
	 */
	public static String createDir(String filepath, String filename) {
		File file = new File(filepath);
		String path = "";
		if (!file.exists()) {
			boolean flag = file.mkdirs();
		}
		path = createFile(filepath+filename);
		return path;

	}
	/**
	 * 创建文件
	 * @param path
	 * @param imgname
	 * @return
	 */
	public static String createFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return path;
	}
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  

}
