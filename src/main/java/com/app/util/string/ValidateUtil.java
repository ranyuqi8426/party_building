package com.app.util.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验格式
 * 
 * @author 孔垂云
 * @date 2016年12月16日
 */
public class ValidateUtil {
	/**
	 * 判断是否是整数
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger(String strInteger) {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher(strInteger);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断输入的“是、否”
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValinamevalue(String fieldValue) {
		if ("否".equals(fieldValue)) {
			return "0";
		}
		return "1";

	}

	/**
	 * 判断输入侧别的“是、否”
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValinamevaluezy(String fieldValue) {
		if ("左".equals(fieldValue)) {
			return "0";
		}
		return "1";

	}

	/**
	 * 判断是否是正整数
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger2(String strInteger) {
		Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");
		Matcher m = p.matcher(strInteger);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是非负整数
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger4(String strInteger) {
		Pattern p = Pattern.compile("^0|[0-9]*[1-9][0-9]*$");
		Matcher m = p.matcher(strInteger);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是正整数加零
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger3(String strInteger) {
		Pattern p = Pattern.compile("^\\d+$");
		Matcher m = p.matcher(strInteger);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是正浮点数加零
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isFloat3(String strFloat) {
		Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
		Matcher m = p.matcher(strFloat);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是float
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isFloat(String strFloat) {
		Pattern p = Pattern.compile("^([+-]?)\\d*\\.\\d+$");
		Matcher m = p.matcher(strFloat);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是正float
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isFloat2(String strFloat) {
		Pattern p = Pattern.compile("^[-+]?\\d+(\\.\\d+)?$");
		Matcher m = p.matcher(strFloat);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是float
	 * 
	 * @author 佟磊
	 * @date 2016年12月20日
	 * @param strFloat
	 *            待验证的字符串
	 * @param n
	 *            小数位精度最大限制(n=0, 则不限制)
	 * @return
	 */
	public static boolean isFloat2(String strFloat, int n) {
		String regex = "^[-+]?\\d+(\\.\\d+)?$";
		if (n > 0) {
			regex = "^[-+]?\\d+(\\.\\d{1," + n + "})?$";
		}
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(strFloat);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否正确日期格式 日期格式yyyy-mm-dd
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isDate(String strDate) {
		Pattern p = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
		Matcher m = p.matcher(strDate);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否正确年份
	 * 
	 * @param strYear
	 * @return
	 */
	public static boolean isYear(String strYear) {
		Pattern p = Pattern.compile("^\\d{4}$");
		Matcher m = p.matcher(strYear);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否超过最大值
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isUpMax(float val) {
		if (val > 9999.999) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否超过最大值
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isUpMax2(float val) {
		if (val > 99999.99) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否超过最大值
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isUpMax4(float val) {
		if (val > 999999.9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否超过最大值
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isUpMax3(float val) {
		if (val > 99.99) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否超过最大值
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isUpMax5(float val) {
		if (val > 99999.999) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否小于0
	 * 
	 * @param val
	 * @return
	 */
	public static boolean islessMax2(float val) {
		if (val < 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 校验字符串为空结果
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateEmpty(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】不能为空\\r\\n";
	}

	/**
	 * 校验数字长度是不是4位
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String ValidatefourLength(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】不是四位\\r\\n";
	}

	/**
	 * 校验字符串
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateLength(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】超长\\r\\n";
	}

	/**
	 * 校验字符串名称不一致
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValiname(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】应为“无砟、有砟”\\r\\n";
	}
	/**
	 * 校验字符串名称不一致
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValiisname(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】应为“无、有”\\r\\n";
	}

	/**
	 * 校验字符串名称不一致
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValisfname(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】应为“是、否”\\r\\n";
	}

	/**
	 * 侧别校验字符串名称不一致,应该为左右
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValisfnamezy(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】应为“左、右”\\r\\n";
	}

	/**
	 * 校验字符为非数字
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateNotNumber(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】非合法数字\\r\\n";
	}

	/**
	 * 校验字符为非日期
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateNotDate(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】非日期格式\\r\\n";
	}

	/**
	 * 校验字符为非年份
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateNotYear(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】非年份格式(yyyy)\\r\\n";
	}

	/**
	 * 校验字符不符合字典要求
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 */
	public static String retValidateNotDic(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】不符合字典要求\\r\\n";
	}

	/**
	 * 校验单位信息是否存在
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2016-12-17
	 */
	public static String retValidateNotDw(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】不存在\\r\\n";
	}

	/**
	 * 校验数据过大
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2016-12-17
	 */
	public static String retValidateMaxValue(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】数据过大\\r\\n";
	}

	/**
	 * 校验数据小于0
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2016-12-17
	 */
	public static String retValidateMinValue(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】数据小于0\\r\\n";
	}

	/**
	 * 校验信息唯一性
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2016-12-17
	 */
	public static String retValidateNotOnly(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】已存在，不可重复添加\\r\\n";
	}

	/**
	 * 校验基本信息中线名是否存在
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2016-12-17
	 */
	public static String retValidateNotExist(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】不存在，不可添加\\r\\n";
	}

	/**
	 * 校验信息匹配性
	 * 
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @author 崔明超
	 * @date 2016-12-26
	 */
	public static String retValidateCheckMate(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】和车站字典不匹配\\r\\n";
	}

	/**
	 * 校验小数位上限
	 * 
	 * @author 佟磊
	 * @date 2016年12月20日
	 * @param row
	 * @param field
	 * @param fieldValue
	 * @param n
	 * @return
	 */
	public static String retValidateDecimalPlaces(int row, String field, String fieldValue, int n) {
		return "第" + row + "行," + field + "【" + fieldValue + "】小数位过大,不得超过" + n + "位\\r\\n";
	}

	/**
	 * 校验工务机械车车型信息是否正确
	 * 
	 * @author 闫长江
	 * @date 2016年12月26日
	 */
	public static String retValidateNotGwjcCx(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】车型与工务机械车编码不匹配\\r\\n";
	}

	/**
	 * 校验工务机械车车种信息是否正确
	 * 
	 * @author 闫长江
	 * @date 2016年12月26日
	 */
	public static String retValidateNotGwjcCz(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】车种与工务机械车编码不匹配\\r\\n";
	}

	/**
	 * 校验省份是否存在
	 * 
	 * @author 闫长江
	 * @date 2017年1月9日
	 */
	public static String retValidateNotSf(int row, String field, String fieldValue) {
		return "第" + row + "行," + field + "【" + fieldValue + "】省份不存在\\r\\n";
	}

	/**
	 * 校验信息一致
	 * 
	 * @param row
	 * @author 余建东
	 * @date 2016-12-26
	 */
	public static String retValidateNotMatch(int row, String field) {
		return "第" + row + "行," + field + "不一致\\r\\n";
	}

	/**
	 * 变更逻辑校验
	 * 
	 * @param row
	 * @param bglx
	 *            变更类型
	 * @param bgfs
	 *            变更方式
	 * @param field
	 *            校验字段
	 * @param errorType
	 *            错误类别
	 * @param fieldValue
	 * @author 乐振雷
	 * @date 2017-01-03
	 */
	public static String retValidateLogic(int row, String bglx, String bgfs, String field, String fieldValue,
			int errorType) {
		String msg = "";
		switch (errorType) {
		case 1:
			msg = "第" + row + "行,变更方式等于" + bgfs + ",开始" + field + "校验\\r\\n";
			break;
		case 2:
			msg = "第" + row + "行,变更类型等于" + bglx + "," + field + "【" + fieldValue + "】不能为空\\r\\n";
			break;
		case 3:
			msg = "第" + row + "行,变更类型等于" + bglx + "," + field + "【" + fieldValue + "】必须为空\\r\\n";
			break;
		case 4:
			msg = "第" + row + "行,变更方式等于" + bgfs + ",结束" + field + "校验\\r\\n";
			break;
		}
		return msg;
	}

	/**
	 * 计算文本中某字符串出现的次数
	 * 
	 * @param sb
	 *            文本
	 * @param field
	 *            字符串
	 * @author 乐振雷
	 * @date 2017-01-04
	 */
	public static Integer stringCount(StringBuffer sb, String field) {
		int count = 0;
		String t = "";// 每次截取的字符串
		int sLength = sb.length();// 文本长度
		int fLength = field.length();// 字符串长度
		int cLength = fLength - 1;// 剩余长度
		for (int i = 0; i < sLength - cLength; i++) {// 判断到最后几位不足field长度时停止循环，以免越界
			t = sb.substring(i, i + fLength);// 从文本sb中截取一段长度为field的字符串定义为原字符串的子字符串
			if (field.equals(t)) {// 利用equals判断两者是否相等，如果结果为true，count++；
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(ValidateUtil.isFloat2("1"));
	}
}
