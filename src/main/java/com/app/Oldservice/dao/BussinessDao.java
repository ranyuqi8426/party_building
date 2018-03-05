package com.app.Oldservice.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.Business;
import com.app.Oldservice.model.DataBiz;
import com.app.Oldservice.model.UserBiz;
import com.app.Oldservice.vo.BusinessVO;
import com.app.util.page.PageUtil;

@Repository
public class BussinessDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(BusinessVO buinessVO) {
		String sql = "";
		if(buinessVO.getEndTime()!=null) {
			sql += " and end_time > :endTime";
		}
		return sql;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Business> list(BusinessVO buinessVO) {
		String sql = "select * from T_USER_SALE t where 1=1";
		sql += createSearchSql(buinessVO);
		sql += " order by end_time desc ";
		PageUtil.createMysqlPageSql(sql, buinessVO.getPage(), buinessVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(buinessVO);
		List<Business> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(Business.class));
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DataBiz> getOne(int biz_id) {
		String sql = "select * from T_DATA_BIZ where Biz_id=?";
		Object[] params = new Object[] { biz_id };
		List<DataBiz> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(DataBiz.class));
		return list;
	}

	public int add(UserBiz userBiz) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into T_USER_BIZ (USER_ID,SALE_ID,CODE) values(:user_id,:sale_id,:code)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userBiz);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	//查询是否已经领取过
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getOne(UserBiz userBiz) {
		String sql = "select * from T_USER_BIZ t where 1=1";
		sql += " and user_id =" + userBiz.getUser_id();
		sql += " and sale_id =" + userBiz.getSale_id();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userBiz);
		List<UserBiz> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(UserBiz.class));
		if(list.size()==0) {
			return 1;
		}else {
			return 0;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String,Object> listMe(BusinessVO businessVO) {
		//未领取
		String sql = "select * from T_USER_SALE t , T_USER_BIZ a where 1=1 and t.sale_id = a.sale_id and a.user_id = :user_id and a.code = '0' ";
		sql += createSearchSql(businessVO);
		sql += " order by t.end_time desc";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(businessVO);
		List<Business> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(Business.class));
		//已领取
		String sql2 = "select * from T_USER_SALE t , T_USER_BIZ a where 1=1  and t.sale_id = a.sale_id and a.user_id = :user_id and a.code = '1' ";
		sql2 += createSearchSql(businessVO);
		sql2 += " order by t.end_time desc";
		List<Business> list2 = namedParameterJdbcTemplate.query(sql2, paramSource, new BeanPropertyRowMapper(Business.class));
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("1", list);
		map.put("2", list2);
		return map;
	}
	/**
	 * 使用优惠券
	 * @return
	 */
	public int update(String id) {
		String sql = "update T_USER_BIZ set code = '1' where id=? ";
		return jdbcTemplate.update(sql, id);
	}
	/**
	 * 删除
	 * @return
	 */
	public int delete(String id) {
		String sql = "delete from T_USER_BIZ where id=? ";
		return jdbcTemplate.update(sql, id);
	}



}
