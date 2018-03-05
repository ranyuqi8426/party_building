package com.app.Oldservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.Desire;
import com.app.Oldservice.model.User;
import com.app.Oldservice.vo.DesireVO;
import com.app.util.page.PageUtil;

@Repository
public class DesireDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(DesireVO desireVO) {
		String sql = "";
		if (desireVO.getStatus()!=null&&desireVO.getStatus()!="") {
			sql += " and status = " + desireVO.getStatus();
		}
		if (desireVO.getAudit_status()!=null&&desireVO.getAudit_status()!="") {
			sql += " and audit_status = " + desireVO.getAudit_status();
		}
		
		return sql;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> getUserName(int user_id) {
		String sql = "select * from T_SYS_USER where user_id=?";
		Object[] params = new Object[] { user_id };
		List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Desire> list(DesireVO desireVO) {
		String sql = "select * from T_USER_WANT t where 1=1";
		sql += createSearchSql(desireVO);
		sql += " order by create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql, desireVO.getPage(), desireVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(desireVO);
		List<Desire> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(Desire.class));
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Desire> getOne(String want_id) {
		String sql = "select * from T_USER_WANT where want_id=?";
		Object[] params = new Object[] { want_id };
		List<Desire> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Desire.class));
		return list;
	}
	public int get(Desire desire) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_want(title,content,user_id,create_time,create_loc,finish_id,finish_time,status,auditor_id,audit_time,audit_status,pic_url1) values(:title,:content,:user_id,:create_time,:create_loc,:finish_id,:finish_time,:status,:auditor_id,:audit_time,:audit_status,:pic_url1)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(desire);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	public int updateFinish(DesireVO desireVO) {
		String sql = "update T_USER_WANT set finish_id=:finish_id,status=:status where want_id=:want_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(desireVO);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

}
