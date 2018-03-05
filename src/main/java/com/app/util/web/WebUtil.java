package com.app.util.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.util.json.JsonUtil;
import com.app.util.session.SessionUtil;
import com.app.util.string.StringUtil;

/**
 * 字符串操作，用于保存和Web输入输出有关的方法
 * 
 * @author chykong
 * 
 */
public class WebUtil {

	/**
	 * Servlet打印字符串
	 * 
	 * @param response
	 * @param str
	 */
	public static void out(HttpServletResponse response, String str) {
		response.setContentType("text/html; charset=UTF-8");
		try {
			if (str.length() < 100)
				response.getWriter().println(str);
			else
				gzipReponse(response, str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void gzipReponse(HttpServletResponse response, String data) {
		try {
			byte[] result = data.getBytes("UTF-8");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gout = new GZIPOutputStream(out);
			gout.write(data.getBytes("UTF-8"));
			gout.close();
			result = out.toByteArray();
			response.setHeader("Content-Encoding", "gzip");
			response.setHeader("Content-Length", result.length + "");
			response.getOutputStream().write(result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回操作成功与否的json串，并传向前台
	 * 
	 * @param response
	 * @param flag
	 */
	public static void outOpera(HttpServletResponse response, int flag) {
		String operaStr = "";
		if (flag == -1)
			operaStr = JsonUtil.createOperaStr(false, "编号超出最大值");
		else if (flag == 0)
			operaStr = JsonUtil.createOperaStr(false, "操作失败");
		else if (flag == 1)
			operaStr = JsonUtil.createOperaStr(true, "操作成功");
		else if (flag == 2)
			operaStr = JsonUtil.createOperaStr(false, "代码已存在!");
		else if (flag == 9)
			operaStr = JsonUtil.createOperaStr(false, "提交后不允许修改和删除!");
		WebUtil.out(response, operaStr);
	}

	/**
	 * 根据字符串转换，如果为null，则变成""
	 * 
	 * @param strName
	 * @return
	 */
	public static String getSafeStr(Object obj) {
		return obj == null ? "" : String.valueOf(obj);
	}

	/**
	 * 根据字符串转换，如果为null，则变成defaultStr
	 * 
	 * @param strName
	 * @return
	 */
	public static String getSafeStr(Object obj, String strDefault) {
		return obj == null ? strDefault : String.valueOf(obj);
	}

	/**
	 * 根据字符串转换，如果为null，则变成0
	 * 
	 * @param strName
	 * @return
	 */
	public static int getSafeInt(Object obj) {
		return obj == null || obj.toString().equals("") ? 0 : Integer.parseInt(String.valueOf(obj));
	}

	/**
	 * 根据字符串转换，如果为null，则变成defaultInt
	 * 
	 * @param strName
	 * @return
	 */
	public static int getSafeInt(Object obj, int nDefualt) {
		return obj == null || obj.toString().equals("") ? nDefualt : Integer.parseInt(String.valueOf(obj));
	}

	/**
	 * 根据字符串转换，如果为null，则变成0
	 * 
	 * @param strName
	 * @return
	 */
	public static double getSafeDouble(Object obj) {
		return obj == null ? 0 : Double.parseDouble(String.valueOf(obj));
	}

	/**
	 * 根据字符串转换，如果为null，则变成defaultDouble
	 * 
	 * @param strName
	 * @return
	 */
	public static double getSafeDouble(Object obj, double nDefualt) {
		return obj == null ? 0 : Double.parseDouble(String.valueOf(obj));
	}

	/**
	 * 根据字符串转换，如果为null，则变成0
	 * 
	 * @param strName
	 * @return
	 */
	public static float getSafeFloat(Object obj) {
		return obj == null ? 0 : Float.parseFloat(String.valueOf(obj));
	}

	/**
	 *  根据字符串转换, 如果为空字符串,则变为0
	 *	@author 闫长江
	 *  @date 2016年12月29日
	 */
	public static float getSafeFloat2(String str) {
		if (str != null)
			return str.equals("") ? 0 : Float.parseFloat(String.valueOf(str));
		return 0;
	}

	/**
	 *  根据字符串转换, 如果为null,则变为0
	 *	@author 闫长江
	 *  @date 2016年12月29日
	 */
	public static int getSafeInteger(Object obj) {
		return obj == null ? 0 : Integer.parseInt(String.valueOf(obj));
	}

	/**
	 *  根据字符串转换, 如果为空字符串,则变为0
	 *	@author 闫长江
	 *  @date 2016年12月29日
	 */
	public static int getSafeInteger2(String str) {
		if (str != null)
			return str.equals("") ? 0 : Integer.parseInt(String.valueOf(str));
		return 0;
	}

	/**
	 * 根据字符串转换，如果为null，则变成defaultDouble
	 * 
	 * @param strName
	 * @return
	 */
	public static float getSafeFloat(Object obj, float nDefualt) {
		return obj == null ? 0 : Float.parseFloat(String.valueOf(obj));
	}

	/**
	 * 判断字符串为“是否”
	 * 
	 * @param str
	 * @return
	 */
	public static boolean issf(String str) {
		if ("是".equals(str) || "否".equals(str))
			return true;
		else
			return false;
	}

	/**
	 * 判断字符串侧别为“左右”
	 * 
	 * @param str
	 * @return
	 */
	public static boolean iszy(String str) {
		if ("左".equals(str) || "右".equals(str))
			return true;
		else
			return false;
	}

	/**
	 * 插入字符串
	 * @param s1
	 * @param s2
	 * @param i
	 * @return
	 */
	public static String getSubString(String s1, String s2, int i) {
		StringBuilder sb = new StringBuilder();
		sb.append(s1).insert(i, s2);
		return sb.toString();

	}

	/**
	 * 插入字符串
	 * @param s1
	 * @return
	 */
	public static String getSyrq(String s1) {
		Integer rq = 0;
		if (s1.substring(4).equals("01")) {
			rq = Integer.parseInt(s1) - 89;
		} else {
			rq = Integer.parseInt(s1) - 1;
		}
		return rq.toString();
	}

	/**
	 * 获取单位id，在报表查询里面用到
	 * @param request
	 * @return
	 */
	public static int getRptDwid(HttpServletRequest request) {
		return request.getParameter("dwid") == null ? SessionUtil.getDwid(request)
				: WebUtil.getSafeInt(request.getParameter("dwid"));
	}


}
