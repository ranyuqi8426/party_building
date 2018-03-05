package com.app.common.dao;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.common.vo.ComboboxVO;
import com.app.util.string.StringUtil;
import com.sun.tools.extcheck.Main;

@Repository
public class CommonDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 下拉列表
	 * 
	 * @param table_name 数据库表名
	 * @param value 编号
	 * @param content 显示内容
	 * @param order 按照什么排序
	 * @param sort 排序是升序还是降序
	 * @param condition 过滤条件
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComboboxVO> listCombobox(String table_name, String value, String content, String order, String sort, String condition) {
		String strSql = "select " + value + " value," + content + " content from " + table_name;
		if (StringUtil.isNotNullOrEmpty(condition))
			strSql += " where " + condition;
		if (StringUtil.isNotNullOrEmpty(order))
			strSql += " order by " + order;
		if (StringUtil.isNotNullOrEmpty(sort))
			strSql += sort;
		return jdbcTemplate.query(strSql, new BeanPropertyRowMapper(ComboboxVO.class));
	}
	public void test() {
//		String sql = "insert info  t_user_show ('user_id') values ('1')";
		String sql = "select count(*) from t_user_show";
		int a = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(a);
	}
}
