package com.app.sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.sys.model.SysLog;
import com.app.sys.vo.SysLogSearchVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;


/**
 * 系统日志dao
 * @author chykong
 *
 */
@Repository
public class SysLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int add(SysLog sysLog) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_sys_log(user_id,opera_date,opera_ip,module_name,opera_name,Opera_url,opera_type,opera_params)"
				+ " values(:user_id,:opera_date,:opera_ip,:module_name,:opera_name,:opera_url,:opera_type,:opera_params)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysLog);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 查询
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysLog> list(SysLogSearchVO sysLogSearchVO, int pageIndex, int pageSize) {
		String sql = "select l.*,u.username username,u.realname realname  from t_sys_log l,t_sys_user u where l.user_id=u.id  ";
		sql += createSearchSql(sysLogSearchVO);
		sql += " order by opera_date desc";
		sql = PageUtil.createMysqlPageSql(sql, pageIndex, pageSize);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysLogSearchVO);
		List<SysLog> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(SysLog.class));
		return list;
	}

	/**
	 * 查询所有，不分页
	 * @param sysLogSearchVO
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SysLog> list(SysLogSearchVO sysLogSearchVO) {
		String sql = "select l.*,u.username username,u.realname realname  from t_sys_log l,t_sys_user u where l.user_id=u.id  ";
		sql += createSearchSql(sysLogSearchVO);
		sql += " order by opera_date desc";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysLogSearchVO);
		List<SysLog> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(SysLog.class));
		return list;
	}

	/**
	 * 查询
	 * 
	 * @param sysUserSearchVO
	 * @return
	 */
	public int listCount(SysLogSearchVO sysLogSearchVO) {
		String sql = "select count(*) from t_sys_log where 1=1 ";
		sql += createSearchSql(sysLogSearchVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysLogSearchVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	private String createSearchSql(SysLogSearchVO sysLogSearchVO) {
		String sql = "";
		if (sysLogSearchVO.getUser_id() != 0) {
			sql += " and user_id=:user_id";
		}
		if (StringUtil.isNotNullOrEmpty(sysLogSearchVO.getS_date())) {
			sql += " and to_char(opera_date,'yyyy-mm-dd')>=:s_date";
		}
		if (StringUtil.isNotNullOrEmpty(sysLogSearchVO.getE_date())) {
			sql += " and to_char(opera_date,'yyyy-mm-dd')<=:e_date";
		}
		return sql;
	}
}
