package com.app.Oldservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldservice.model.Business;
import com.app.Oldservice.vo.BusinessDiscountVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;
@Repository
public class BusinessDiscountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询总数
	 */
	public int listCount(BusinessDiscountVO BusinessDiscountVO) {
		String sql = "select count(*) from t_user_sale t,t_data_biz b where 1=1  and t.biz_id = b.biz_id";
		sql += createSearchSql(BusinessDiscountVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BusinessDiscountVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	/**
	 * 分页查询
	 */
	public List<Business> list(BusinessDiscountVO BusinessDiscountVO) {
		String sql = "select t.*";
		sql += " from t_user_sale t,t_data_biz b";
		sql += " where 1=1 and t.biz_id = b.biz_id ";
		sql += createSearchSql(BusinessDiscountVO);
		sql += " order by t.end_time desc";
		sql = PageUtil.createMysqlPageSql(sql, BusinessDiscountVO.getPage(), BusinessDiscountVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BusinessDiscountVO);
		List<Business> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(Business.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(BusinessDiscountVO BusinessDiscountVO) {
		String sql = " and b.user_id  = :user_id";
		if (StringUtil.isNotNullOrEmpty(BusinessDiscountVO.getTitle())) {
			BusinessDiscountVO.setTitle("%"+BusinessDiscountVO.getTitle()+"%");
			sql += " and t.title  like :title";
		}
		if (StringUtil.isNotNullOrEmpty(BusinessDiscountVO.getDate_start())) {
			sql += " and date(t.end_time) >= :date_start";
		}
		if (StringUtil.isNotNullOrEmpty(BusinessDiscountVO.getDate_end())) {
			sql += " and date(t.end_time) <= :date_end";
		}
		return sql;
	}

	/**
	 * 新增
	 */
	public int add(Business Business) {
		String sql = "insert into t_user_sale(learning_data_title,learning_data_url,learning_content,learning_pic_url,learning_data_type,create_user_id,create_date)";
		sql +=  "values(:learning_data_title,:learning_data_url,:learning_content,:learning_pic_url,:learning_data_type,:create_user_id,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(Business);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 修改
	 */
	public int update(Business Business) {
		String sql = "update t_user_sale ";
		sql += " set learning_data_title=:learning_data_title,learning_content=:learning_content,create_user_id=:create_user_id,create_date=:create_date ";
		sql+= " where biz_id=:biz_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(Business);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 获取一条记录
	 */
	public Business get(int biz_id) {
		String sql = "select * from t_user_sale where biz_id=?";
		Object[] params = new Object[] { biz_id };
		List<Business> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Business.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	

	/**
	 * 删除
	 */
	public int delete(int biz_id) {
		String sql = "delete from t_user_sale where biz_id=?";
		return jdbcTemplate.update(sql, biz_id);
	}
}
