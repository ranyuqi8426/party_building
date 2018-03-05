package com.app.Oldservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.DataBiz;
import com.app.Oldservice.vo.BusinessManagerVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;
@Repository
public class BusinessManagerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询总数
	 */
	public int listCount(BusinessManagerVO BusinessManagerVO) {
		String sql = "select count(*) from t_data_biz where 1=1   ";
		sql += createSearchSql(BusinessManagerVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BusinessManagerVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	/**
	 * 分页查询
	 */
	public List<DataBiz> list(BusinessManagerVO BusinessManagerVO) {
		String sql = "select *";
		sql += " from t_data_biz t,t_sys_user a";
		sql += " where 1=1 and t.user_id = a.user_id";
		sql += createSearchSql(BusinessManagerVO);
		sql += " order by t.biz_id desc";
		sql = PageUtil.createMysqlPageSql(sql, BusinessManagerVO.getPage(), BusinessManagerVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BusinessManagerVO);
		List<DataBiz> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(DataBiz.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(BusinessManagerVO BusinessManagerVO) {
		String sql = "";
		if (StringUtil.isNotNullOrEmpty(BusinessManagerVO.getName())) {
			BusinessManagerVO.setName("%"+BusinessManagerVO.getName()+"%");
			sql += " and name  like :name";
		}
		if (StringUtil.isNotNullOrEmpty(BusinessManagerVO.getStatus())) {
			sql += " and status = :status";
		}
		return sql;
	}

	/**
	 * 新增
	 */
	public int add(DataBiz DataBiz) {
		String sql = "insert into t_data_biz(learning_data_title,learning_data_url,learning_content,learning_pic_url,learning_data_type,create_user_id,create_date)";
		sql +=  "values(:learning_data_title,:learning_data_url,:learning_content,:learning_pic_url,:learning_data_type,:create_user_id,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(DataBiz);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 修改
	 */
	public int update(DataBiz DataBiz) {
		String sql = "update t_data_biz ";
		sql += " set learning_data_title=:learning_data_title,learning_content=:learning_content,create_user_id=:create_user_id,create_date=:create_date ";
		sql+= " where biz_id=:biz_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(DataBiz);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 获取一条记录
	 */
	public DataBiz getOne(int user_id) {
		String sql = "select * from t_sys_user t,t_data_biz c where 1=1   and t.user_id  = ? and t.user_id = c.user_id";
		Object[] params = new Object[] { user_id };
		List<DataBiz> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(DataBiz.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	

	/**
	 * 删除
	 */
	public int delete(int biz_id) {
		String sql = "delete from t_data_biz where biz_id=?";
		return jdbcTemplate.update(sql, biz_id);
	}
}
