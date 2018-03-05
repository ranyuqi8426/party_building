package com.app.OldpartyLecture.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.Oldlifecircle.model.UserCollection;
import com.app.OldpartyLecture.model.RealTimeMessage;
import com.app.OldpartyLecture.vo.RealTimeMessageVO;
import com.app.util.page.PageUtil;

@Repository
public class RealTimeMessageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RealTimeMessage> list(RealTimeMessageVO RealTimeMessageVO) {
		String sql = "select t.*,(select b.id from t_user_collection b where b.collection_id = t.realtimeinfo_id and b.collection_type='2' and b.user_id = :user_id ) As collection_id from t_data_realtime t where 1=1";
		sql += createSearchSql(RealTimeMessageVO);
		sql += " order by t.realtimeinfo_time desc";
		sql = PageUtil.createMysqlPageSql(sql,RealTimeMessageVO.getPage(),RealTimeMessageVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessageVO);
		List<RealTimeMessage> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(RealTimeMessage.class));
		return list;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(RealTimeMessageVO RealTimeMessageVO) {
		String sql = "";
		// if (StringUtil.isNotNullOrEmpty(RealTimeMessageVO.getBank_id())) {
		// sql += " and bank_id = :bank_id";
		// }

		return sql;
	}
	// /**
	// * 新建关系
	// * @return
	// */
	// public int addUserShow(UserShow userShow) {
	// userShow.setCreate_date(new Date());
	// NamedParameterJdbcTemplate namedParameterJdbcTemplate = new
	// NamedParameterJdbcTemplate(jdbcTemplate);
	// String sql = "insert into
	// t_user_show(show_id,user_id,do_type,comment,create_date)
	// values(:show_id,:user_id,:do_type,:comment,:create_date)";
	// SqlParameterSource paramSource = new
	// BeanPropertySqlParameterSource(userShow);
	// return namedParameterJdbcTemplate.update(sql, paramSource);
	// }

	/**
	 * 获取一条记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RealTimeMessage> get(RealTimeMessageVO RealTimeMessageVO) {
		String sql = "select t.*,(select b.id from t_user_collection b where b.collection_id = t.realtimeinfo_id and b.collection_type='2' and b.user_id = :user_id ) As collection_id from t_data_realtime t where 1=1 and realtimeinfo_id = :realtimeinfo_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessageVO);
		List<RealTimeMessage> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(RealTimeMessage.class));
		if (list != null && list.size() > 0) {
			updateSeeNum(list.get(0).getRealtimeinfo_id());
		}
		return list;
	}

	/**
	 * 增加查看数
	 * 
	 * @return
	 */
	public int updateSeeNum(int realtimeinfo_id) {
		RealTimeMessage RealTimeMessage = new RealTimeMessage();
		RealTimeMessage.setRealtimeinfo_id(realtimeinfo_id);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "update t_data_realtime set read_num = read_num+1 where realtimeinfo_id = :realtimeinfo_id";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(RealTimeMessage);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	// /**
	// * 取消点赞
	// * @return
	// */
	// public int deleteUserShow(int id,int user_id) {
	// String sql = "delete from t_user_show where show_id=? and user_id=? and
	// do_type = '2'";
	// return jdbcTemplate.update(sql, id,user_id);
	// }
	/**
	 * 收藏
	 * 
	 * @return
	 */
	public int addCollection(UserCollection userCollection) {
		userCollection.setCreate_date(new Date());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_collection(collection_id,user_id,collection_type,create_date) values(:collection_id,:user_id,:collection_type,:create_date)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userCollection);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 取消收藏
	 * 
	 * @return
	 */
	public int deleteCollection(int id, int user_id) {
		String sql = "delete from t_user_collection where collection_id=? and user_id=? and collection_type = '2'";
		return jdbcTemplate.update(sql, id, user_id);
	}

}
