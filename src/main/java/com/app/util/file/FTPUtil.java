package com.app.util.file;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 
 * <p>Title: FTPUtil.java</p>
 * <p>Description: </p>
 * @author lida
 * @date 2017年11月3日
 */
public class FTPUtil {
	
	private static FTPClient ftp;      
    /**  
     *   
     * @param path 上传到ftp服务器哪个路径下     
     * @param addr 地址  
     * @param port 端口号  
     * @param username 用户名  
     * @param password 密码  
     * @return  
     * @throws Exception  
     */    
    public static boolean connect(String path,String addr,int port,String username,String password) throws Exception {      
        boolean result = false;      
        ftp = new FTPClient();      
        int reply;      
        ftp.connect(addr,port);      
        ftp.login(username,password);      
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);  
        reply = ftp.getReplyCode();      
        if (!FTPReply.isPositiveCompletion(reply)) {      
            ftp.disconnect();      
            return result;      
        }
      //新建目录/创建多层目录
        StringTokenizer s = new StringTokenizer(path, "/");
        s.countTokens(); 
        String pathName = ""; 
        while (s.hasMoreElements()) { 
               pathName = pathName + "/" + (String) s.nextElement(); 
               try { 
                  ftp.mkd(pathName); 
               } catch (Exception e) { 
                   System.out.println("ftp文件夹创建失败");
               } 
        } 
        
        //进入目录
        boolean  a = ftp.changeWorkingDirectory(path);  
        if (a) {
            result = true;      
        }
        return result;      
    }
      
    /**
     * 
     * @param file 上传的文件或文件夹  
     * @param file
     * @return
     */
    public static Boolean upload(File file){      
        try {
            if(file.isDirectory()){           
                ftp.makeDirectory(file.getName());                
                ftp.changeWorkingDirectory(file.getName());      
                String[] files = file.list();             
                for (int i = 0; i < files.length; i++) {      
                    File file1 = new File(file.getPath()+"\\"+files[i] );      
                    if(file1.isDirectory()){      
                        upload(file1);      
                        ftp.changeToParentDirectory();      
                    }else{                    
                        File file2 = new File(file.getPath()+"\\"+files[i]);      
                        FileInputStream input = new FileInputStream(file2);      
                        Boolean res = ftp.storeFile(file2.getName(), input);      
                        input.close();                            
                    }                 
                }      
            }else{      
                File file2 = new File(file.getPath());
                FileInputStream input = new FileInputStream(file2);      
                Boolean res = ftp.storeFile(file2.getName(), input);      
                input.close();        
            }
            return true;      
        } catch (IOException e) {
            e.printStackTrace();
            return false;      
        }
    }      
    

    /**
     * 
     * <p>Title:uploadImage</p>
     * <p>Description:上传图片</p>
     * @param fileName
     * @param input
     * @return
     */
    public static Boolean uploadImage(String fileName,InputStream input){
    	try {
            ftp.enterLocalPassiveMode();
            ftp.storeFile(fileName, input);      
            input.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /***
	 * 判断路径是否存在，不存在创建
	 * 
	 * @throws SftpException
	 */
    public boolean mkdir(String directory)  {
		
		try {
			String[] directoryArr = directory.split("/");
			FTPFile[] FTPFileArr;
			FTPFileArr = ftp.listDirectories();
			for(int i=0;i<FTPFileArr.length;i++){
				System.out.println("------------------"+FTPFileArr[i].getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return true;
	}
//   public static void main(String[] args){    
//	   FTPClient ftp = new FTPClient();
//	  
//      try{
//    	  ftp.connect("47.93.151.7", 21); 
//    	  ftp.login("wwwftp", "hmt4006608258");
//    	  int reply = ftp.getReplyCode(); 
//    	  
//    	  System.out.println(reply);
//    	  
//    	  ftp.enterLocalPassiveMode();
//    	  System.out.println(FTPReply.isPositiveCompletion(reply));
//    	  
//    	  boolean b=ftp.changeWorkingDirectory("/var/ftp/PictureServer/images/20170627");
//    	  
//    	  System.out.println(b);
//    	  
//    	  ftp.setBufferSize(1024);   
//          ftp.setControlEncoding("utf-8");  
//          boolean ret = ftp.setFileType(FTPClient.BINARY_FILE_TYPE);   
//          if(ret){  
//        	  File file = new File("D:\\logo.jpg");    
//              InputStream is = new FileInputStream(file);
//              ret=ftp.storeFile("xxx.png", is);
//              System.out.println(ret);
//          }  
//    	  
//    	  
//    	  
//    	  
//    	 FTPFile[] FTPFileArr;
//    	 FTPFileArr = ftp.listFiles("/images");
//		for(int i=0;i<FTPFileArr.length;i++){
//				System.out.println("------------------"+FTPFileArr[i].getName());
//		}
//		ftp.disconnect();      
//      }catch(Exception e){
//    	  e.printStackTrace();
//      }
//   }
    
    /**从FTP服务器下载文件
	 * <p>Title:downFile</p>
	 * <p>Description:	</p>
	 * @author songchaoshuai
	 * @Date   2017年1月9日下午5:33:35
	 * @param url
	 * @param port
	 * @param username
	 * @param password
	 * @param remotePath
	 * @param fileName
	 * @param localPath
	 * @return boolean
	 */
	public static boolean downFile(String url, int port, String username, String password, 
			String remotePath, String fileName, String localPath) {
		FTPClient ftpClient = new FTPClient();
		boolean result = false;
		try {
			//获取系统编码
			String encoding = System.getProperty("file.encoding");
			ftpClient.setControlEncoding(encoding);
			//ftp服务器登录凭证 
			ftpClient.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			int reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return result;
			}
			//设置从数据连接读取时使用的毫秒超时时间.
			ftpClient.setDataTimeout(5000);
			ftpClient.setControlKeepAliveTimeout(300); // set timeout to 5 minutes
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			
			ftpClient.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}
	
	
	/**
	* <p>Title:deleteImage </p>
	* <p>Description: 删除ftp文件</p>
	* @author huzt
	* @date 2017年8月24日 下午2:59:55
	 */
	public static boolean deleteImage(String srcFname){  
        boolean flag = false;  
        if( ftp!=null ){  
            try {  
                flag = ftp.deleteFile(srcFname);  
            } catch (IOException e) {  
                e.printStackTrace();  
                FTPUtil.closeCon();  
            }  
        }  
        return flag;  
    }
	
	/**
	* <p>Title:closeCon </p>
	* <p>Description: 关闭ftp连接</p>
	* @author huzt
	* @date 2017年8月24日 下午3:00:22
	 */
	public static void closeCon(){  
        if(ftp !=null){  
            if(ftp.isConnected()){  
                try {  
                	ftp.logout();  
                	ftp.disconnect();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }   
            }  
        }  
    }
}