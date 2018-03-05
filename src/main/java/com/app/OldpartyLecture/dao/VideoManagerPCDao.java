package com.app.OldpartyLecture.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.OldpartyLecture.model.DataManagerPC;
import com.app.OldpartyLecture.vo.DataManagerPCVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;
@Repository
public class VideoManagerPCDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询总数
	 */
	public int listCount(DataManagerPCVO dataManagerPCVO) {
		String sql = "select count(*) from t_data_learn where 1=1 and learning_data_type = '1' ";
		sql += createSearchSql(dataManagerPCVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(dataManagerPCVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	/**
	 * 分页查询
	 */
	public List<DataManagerPC> list(DataManagerPCVO dataManagerPCVO) {
		String sql = "select t.*, (select P1.username from t_sys_user p1 where p1.user_id = t.create_user_id ) create_user_name";
		sql += " from t_data_learn t";
		sql += " where 1=1 and t.learning_data_type = '1'";
		sql += createSearchSql(dataManagerPCVO);
		sql += " order by t.create_date desc";
		sql = PageUtil.createMysqlPageSql(sql, dataManagerPCVO.getPage(), dataManagerPCVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(dataManagerPCVO);
		List<DataManagerPC> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(DataManagerPC.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(DataManagerPCVO dataManagerPCVO) {
		String sql = "";
		if (StringUtil.isNotNullOrEmpty(dataManagerPCVO.getLearning_data_title())) {
			dataManagerPCVO.setLearning_data_title("%"+dataManagerPCVO.getLearning_data_title()+"%");
			sql += " and learning_data_title  like :learning_data_title";
		}
		if (StringUtil.isNotNullOrEmpty(dataManagerPCVO.getDate_start())) {
			sql += " and date(create_date) >= :date_start";
		}
		if (StringUtil.isNotNullOrEmpty(dataManagerPCVO.getDate_end())) {
			sql += " and date(create_date) <= :date_end";
		}
		return sql;
	}

	/**
	 * 新增
	 */
	public int add(DataManagerPC DataManagerPC) {
		String sql = "insert into t_data_learn(learning_data_title,learning_data_url,learning_content,learning_pic_url,learning_data_type,create_user_id,create_date)";
		sql +=  "values(:learning_data_title,:learning_data_url,:learning_content,:learning_pic_url,:learning_data_type,:create_user_id,:create_date)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(DataManagerPC);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

//	/**
//	 * 修改
//	 */
//	public int update(DataManagerPC DataManagerPC) {
//		String sql = "update t_data_learn ";
//		sql += " set learning_data_title=:learning_data_title,learning_data_url=:learning_data_url,learning_content=:learning_content,learning_pic_url=:learning_pic_url,learning_data_type=:learning_data_type,create_user_id=:create_user_id,create_date=:create_date ";
//		sql+= " where learning_data_id=:learning_data_id";
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(DataManagerPC);
//		return namedParameterJdbcTemplate.update(sql, paramSource);
//	}
	/**
	 * 获取一条记录
	 */
	public DataManagerPC get(int learning_data_id) {
		String sql = "select * from t_data_learn where learning_data_id=?";
		Object[] params = new Object[] { learning_data_id };
		List<DataManagerPC> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(DataManagerPC.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	

	/**
	 * 删除
	 */
	public int delete(int learning_data_id) {
		String sql = "delete from t_data_learn where learning_data_id=?";
		return jdbcTemplate.update(sql, learning_data_id);
	}
}
