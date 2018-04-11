package com.app.util.file;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import com.app.util.constant.ConstantUtil;


/**
 * 
 * <p>ClassName:FTPUtil</p>
 * <p>Description:	上传图片</p>
 * <p>Company: www.shopin.net</p>
 * @version  1.0
 */
public class FileUploadUtil {
    private static String ftpIp = ConstantUtil.ftpIp;//GlobalConstants.getString("ftpIp");
    private static int ftpPort = ConstantUtil.ftpPort;//GlobalConstants.getInt("ftpPort");
    private static String ftpUserName = ConstantUtil.ftpUserName;//GlobalConstants.getString("ftpUserName");
    private static String ftpPassWord = ConstantUtil.ftpPassWord;//GlobalConstants.getString("ftpPassWord");
//    private static String projectName = GlobalConstants.getString("projectName");
//    private static String fileServerUrl = GlobalConstants.getString("fileServerUrl");
    /**
     * 上传文件到ftp服务器的path文件夹下
     * @param savename
     * @param file  MultipartFile
     * @param path
     * @return
     */
    public static String uploadFile(String savename,InputStream file,String path){
        String url = null;
        try {
            Boolean res = FTPUtil.connect(path, ftpIp, ftpPort, ftpUserName, ftpPassWord);
            if (res) {
                Boolean res1 = FTPUtil.uploadImage(savename,file );
                if (res1) {
//                    url = fileServerUrl + path + "/" + savename;
                    url = path + "/" + savename;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                FTPUtil.closeCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return url;
    } 
    /**
     * 读取文件流上传到ftp服务器的path文件夹下
     * @param savename
     * @param input  InputStream
     * @param path
     * @return
     */
    public static String uploadFile1(String savename,InputStream input,String path){
        String url = null;
        try {
            Boolean res = FTPUtil.connect(path, ftpIp, ftpPort, ftpUserName, ftpPassWord);
            if (res) {
                Boolean res1 = FTPUtil.uploadImage(savename, input);
                if (res1) {
//                    url = fileServerUrl + path + "/" + savename;
                    url = path + "/" + savename;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                FTPUtil.closeCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return url;
    }
    

    /**
     * 
     * 删除ftp上的文件
     * @param path      文件路径
     * @param filename  文件名
     * @return
     * 功能测试不通过
     */
    public static boolean deleteImage(String path,String filename){
        Boolean r = false;
        try {
            Boolean res = FTPUtil.connect(path, ftpIp, ftpPort, ftpUserName, ftpPassWord);
            if (res) {
                r = FTPUtil.deleteImage(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                FTPUtil.closeCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }
    /**
     * 传入文件全称，删除ftp文件
     * @param fullname
     * @return
     * 功能测试不通过
     */
    public static boolean deleteFile(String fullname){
        Boolean r = false;
        String filename ="";
        String path ="";
        try {
            URI uri = new URI(fullname);
            String fullpath = uri.getPath();
            String[] split = fullpath.split("/");
            filename = split[split.length-1];
            path = fullpath.replace("/"+filename, "");
            path = path.substring(1, path.length());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
            return false;
        }

        
        try {
            Boolean res = FTPUtil.connect(path, ftpIp, ftpPort, ftpUserName, ftpPassWord);
            if (res) {
                r = FTPUtil.deleteImage(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                FTPUtil.closeCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }
    public static boolean deleteFileImg(String fullname){
        Boolean r = false;
        String filename ="";
        String path ="";
        try {
            URI uri = new URI(fullname);
            String fullpath = uri.getPath();
            String[] split = fullpath.split("/");
            filename = split[split.length-1];
            path = fullpath.replace("/"+filename, "");
            path=path.substring(path.lastIndexOf("/")+1);
            if(path.equals("file")){
            	path="";
            }else{
            	path=path;
            }
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
            return false;
        }

        
        try {
            Boolean res = FTPUtil.connect(path, ftpIp, ftpPort, ftpUserName, ftpPassWord);
            if (res) {
                r = FTPUtil.deleteImage(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                FTPUtil.closeCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }
//	/**
//	* @Title: uploadImg
//	* @Description: springmvc文件上传封装
//	* @param pic
//	* @param folderName
//	* @return    设定文件
//	* String    返回类型
//	* @throws
//	*/ 
//	public static String uploadImg(MultipartFile pic,String folderName) {
//		String OriginalFilename  = pic.getOriginalFilename();
//		String suffix=OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);
//		String savename = UUIDGenerator.generate()+"."+suffix;
//		String date = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
//		String url = FileUploadUtil.uploadFile(savename, pic,projectName+"/"+folderName+"/"+date);
//		return url;
//	}

}