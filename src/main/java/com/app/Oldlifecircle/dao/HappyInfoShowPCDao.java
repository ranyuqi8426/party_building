package com.app.Oldlifecircle.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;


/**
 *
 */
@Repository
public class HappyInfoShowPCDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询总数
	 */
	public int listCount(HappyInfoShowVO HappyInfoShowVO) {
		String sql = "select count(*) from t_data_show where 1=1 ";
		sql += createSearchSql(HappyInfoShowVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyInfoShowVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HappyInfoShow> list(HappyInfoShowVO HappyInfoShowVO, int pageIndex, int pageSize) {
		String sql = "select * from t_data_show t where 1=1 ";
		sql += createSearchSql(HappyInfoShowVO);
		sql += " order by create_time desc";
		sql = PageUtil.createMysqlPageSql(sql, pageIndex, pageSize);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyInfoShowVO);
		List<HappyInfoShow> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(HappyInfoShow.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(HappyInfoShowVO HappyInfoShowVO) {
		String sql = "";
		if (StringUtil.isNotNullOrEmpty(HappyInfoShowVO.getAudit_status())) {
			sql += " and audit_status = :audit_status";
		};
		if (StringUtil.isNotNullOrEmpty(HappyInfoShowVO.getCreate_date_star())) {
			sql += " and create_time >= :create_date_star";
		}
		if (StringUtil.isNotNullOrEmpty(HappyInfoShowVO.getCreate_date_end())) {
			sql += " and create_time <= :create_date_end";
		}
		return sql;
	}

	/**
	 * 新增
	 */
	public int add(HappyInfoShow HappyInfoShow) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_data_show(exchange_id,user_id,goods_id,goods_name,exchange_date,exchange_point,deli_address,deli_contacts,deli_mobile,status) values(seq_t_data_show.nextval,:user_id,:goods_id,:goods_name,:exchange_date,:exchange_point,:deli_address,:deli_contacts,:deli_mobile,:status)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyInfoShow);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 修改
	 */
	public int update(String show_id,String Status,int auditor_id) {
		String sql = " update t_data_show set audit_status=?,audit_time=?,auditor_id=? where show_id=?";
		Object params[] = new Object[] {Status,new java.sql.Date(new Date().getTime()),auditor_id, show_id };
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public int delete(String id) {
		String sql = "delete from t_data_show where show_id=? ";
		return jdbcTemplate.update(sql, id);
	}

	/**
	 * 获取一条记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HappyInfoShow get(String id) {
		String sql = "select * from t_data_show where exchange_id=? ";
		Object[] params = new Object[] { id };
		List<HappyInfoShow> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(HappyInfoShow.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

}
