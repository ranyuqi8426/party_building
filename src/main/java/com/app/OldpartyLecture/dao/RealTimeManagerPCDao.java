package com.app.OldpartyLecture.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.OldpartyLecture.vo.RealTimeMessagePCVO;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;
@Repository
public class RealTimeManagerPCDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询总数
	 */
	public int listCount(RealTimeMessagePCVO RealTimeMessagePCVO) {
		String sql = "select count(*) from t_data_realtime where 1=1  ";
		sql += createSearchSql(RealTimeMessagePCVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessagePCVO);
		return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

	/**
	 * 分页查询
	 */
	public List<RealTimeMessage> list(RealTimeMessagePCVO RealTimeMessagePCVO) {
		String sql = "select t.* from t_data_realtime t where 1=1";
		sql += createSearchSql(RealTimeMessagePCVO);
		sql += " order by t.realtimeinfo_time desc";
		sql = PageUtil.createMysqlPageSql(sql, RealTimeMessagePCVO.getPage(), RealTimeMessagePCVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessagePCVO);
		List<RealTimeMessage> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(RealTimeMessage.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(RealTimeMessagePCVO RealTimeMessagePCVO) {
		String sql = "";
		if (StringUtil.isNotNullOrEmpty(RealTimeMessagePCVO.getRealtimeinfo_title())) {
			RealTimeMessagePCVO.setRealtimeinfo_title("%"+RealTimeMessagePCVO.getRealtimeinfo_title()+"%");
			sql += " and learning_data_title  like :learning_data_title";
		}
		if (StringUtil.isNotNullOrEmpty(RealTimeMessagePCVO.getDate_start())) {
			sql += " and date(create_date) >= :date_start";
		}
		if (StringUtil.isNotNullOrEmpty(RealTimeMessagePCVO.getDate_end())) {
			sql += " and date(create_date) <= :date_end";
		}
		return sql;
	}

	/**
	 * 新增
	 */
	public int add(RealTimeMessage RealTimeMessage) {
		String sql = "insert into t_data_realtime(realtimeinfo_title,realtimeinfo_content,read_num,realtimeinfo_time,create_name,img_url1,img_url2,img_url3，upload_id)";
		sql +=  "values(:realtimeinfo_title,:realtimeinfo_content,:read_num,:realtimeinfo_time,:create_name,:img_url1,:img_url2,:img_url3,:upload_id)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessage);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

//	/**
//	 * 修改
//	 */
//	public int update(RealTimeMessage RealTimeMessage) {
//		String sql = "update t_data_realtime ";
//		sql += " set learning_data_title=:learning_data_title,learning_data_url=:learning_data_url,learning_content=:learning_content,learning_pic_url=:learning_pic_url,learning_data_type=:learning_data_type,create_user_id=:create_user_id,create_date=:create_date ";
//		sql+= " where realtimeinfo_id=:realtimeinfo_id";
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessage);
//		return namedParameterJdbcTemplate.update(sql, paramSource);
//	}
	/**
	 * 获取一条记录
	 */
	public RealTimeMessage get(int realtimeinfo_id) {
		String sql = "select * from t_data_realtime where learning_data_id=?";
		Object[] params = new Object[] { realtimeinfo_id };
		List<RealTimeMessage> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(RealTimeMessage.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	

	/**
	 * 删除
	 */
	public int delete(int realtimeinfo_id) {
		String sql = "delete from t_data_realtime where realtimeinfo_id=?";
		return jdbcTemplate.update(sql, realtimeinfo_id);
	}
}
