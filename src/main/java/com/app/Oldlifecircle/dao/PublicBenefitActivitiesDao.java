package com.app.Oldlifecircle.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.Oldlifecircle.model.HappyParty;
import com.app.Oldlifecircle.model.UserActivity;
import com.app.Oldlifecircle.vo.HappyPartyVO;
import com.app.util.page.PageUtil;
@Repository
public class PublicBenefitActivitiesDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HappyParty> list(HappyPartyVO HappyPartyVO) {
		String sql = "select * from t_data_activity t where 1=1 and statue != '2' and type = '2' and audit_status= '1'";
		sql += createSearchSql(HappyPartyVO);
		sql += " order by t.begin_time desc";
		sql = PageUtil.createMysqlPageSql(sql,HappyPartyVO.getPage(),HappyPartyVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyPartyVO);
		List<HappyParty> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(HappyParty.class));
		return list;
	}
	/**
	 * 分页查询 2
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String,Object> listMe(HappyPartyVO HappyPartyVO) {
		String sql = "select * from t_user_activity t,t_data_activity a where 1=1 and t.activity_id=a.activity_id and a.type = '2' and t.user_type= '1' and user_id = :uid";
		sql += createSearchSql(HappyPartyVO);
		sql += " order by t.last_time desc";
		sql = PageUtil.createMysqlPageSql(sql,HappyPartyVO.getPage(),HappyPartyVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyPartyVO);
		List<HappyParty> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(HappyParty.class));
		String sql2 = "select * from t_user_activity t,t_data_activity a where 1=1 and t.activity_id=a.activity_id and a.type = '2' and t.user_type= '2' and user_id = :uid";
		sql2 += createSearchSql(HappyPartyVO);
		sql2 += " order by t.last_time desc";
		List<HappyParty> list2 = namedParameterJdbcTemplate.query(sql2, paramSource, new BeanPropertyRowMapper(HappyParty.class));
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("1", list);
		map.put("2", list2);
		return map;
	}

	/**
	 * 生成查询条件
	 */
	private String createSearchSql(HappyPartyVO HappyPartyVO) {
		String sql = "";
//	if (StringUtil.isNotNullOrEmpty(HappyPartyVO.getBank_id())) {
//		sql += " and bank_id = :bank_id";
//	}

		return sql;
	}
	/**
	 * 获取一条记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HappyParty> get(String id,String uid) {
		String sql = "select t.*,(select count(*) from t_user_activity a where a.activity_id = t.activity_id and a.user_id = '"+uid+"') as user_id  from t_data_activity t where t.activity_id=?";
		Object[] params = new Object[] { id };
		List<HappyParty> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(HappyParty.class));
		return list;
	}
	/**
	 * 新增
	 */
	public int add(HappyParty HappyParty) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_data_activity(activity_name,content,number_total,number_real,type,item,begin_time,end_time,statue,remark,audit_status,img_url) values(:activity_name,:content,:number_total,:number_real,:type,:item,:begin_time,:end_time,:statue,:remark,:audit_status,:img_url)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyParty);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"id"});
		int flag = 0 ;
		if (rc > 0) {
			int activity_id = keyHolder.getKey().intValue();
			UserActivity UserActivity = new UserActivity();
			UserActivity.setActivity_id(activity_id);
			// 公益活动
			UserActivity.setActivity_type("2");
			UserActivity.setUser_id(HappyParty.getUser_id());
			//创建者
			UserActivity.setUser_type("1");
			flag = addUserActivity(UserActivity);
		}
		return flag;
	}
	/**
	 * 新建关系
	 * @return
	 */
	public int addUserActivity(UserActivity userActivity) {
		userActivity.setCreate_time(new Date());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_activity(activity_id,user_id,activity_type,user_type,create_time) values(:activity_id,:user_id,:activity_type,:user_type,:create_time)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userActivity);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}


}
