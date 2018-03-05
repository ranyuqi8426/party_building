package com.app.Oldlifecircle.dao;

import java.util.Date;
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

import com.app.Oldlifecircle.model.HappyInfoShow;
import com.app.Oldlifecircle.model.UserCollection;
import com.app.Oldlifecircle.model.UserShow;
import com.app.Oldlifecircle.vo.HappyInfoShowVO;
import com.app.util.page.PageUtil;
@Repository
public class HappyInfoShowDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HappyInfoShow> list(HappyInfoShowVO HappyInfoShowVO) {
		String sql = "select t.*,(select a.id from t_user_show a where a.show_id = t.show_id and a.do_type='2'and a.user_id = :user_id) As like_id,(select b.id from t_user_collection b where b.collection_id = t.show_id and b.collection_type='1' and b.user_id = :user_id ) As collection_id from t_data_show t where 1=1  and audit_status= '1'";
		sql += createSearchSql(HappyInfoShowVO);
		sql += " order by t.create_time desc";
		sql = PageUtil.createMysqlPageSql(sql,HappyInfoShowVO.getPage(),HappyInfoShowVO.getLimit());
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
//	if (StringUtil.isNotNullOrEmpty(HappyInfoShowVO.getBank_id())) {
//		sql += " and t.bank_id = :bank_id";
//	}

		return sql;
	}
	/**
	 * 新增
	 */
	public int add(HappyInfoShow HappyInfoShow) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_data_show(content,create_time,location_desc,audit_status,read_num,img_one,img_two,img_three,img_four,img_five,img_six,img_seven,img_eight,img_nine) values(:content,:create_time,:location_desc,:audit_status,:read_num,:img_one,:img_two,:img_three,:img_four,:img_five,:img_six,:img_seven,:img_eight,:img_nine)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyInfoShow);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"id"});
		int flag = 0 ;
		if (rc > 0) {
			int Show_id = keyHolder.getKey().intValue();
			UserShow userShow = new UserShow();
			userShow.setShow_id(Show_id);
			//创建者
			userShow.setDo_type("1");
			userShow.setUser_id(HappyInfoShow.getUser_id());
			flag = addUserShow(userShow);
		}
		return flag;
	}
	/**
	 * 新建关系
	 * @return
	 */
	public int addUserShow(UserShow userShow) {
		userShow.setCreate_date(new Date());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_show(show_id,user_id,do_type,comment,create_date) values(:show_id,:user_id,:do_type,:comment,:create_date)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userShow);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 获取一条记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HappyInfoShow> get(HappyInfoShowVO HappyInfoShowVO) {
		String sql = "select t.*,(select username from t_sys_user b where b.user_id = (select a1.user_id from t_user_show a1 where a1.show_id = t.show_id and a1.do_type = '1') ) as user_name ,(select count(*) from t_user_show a where a.show_id = t.show_id and a.do_type = '2') as likesum ,(select c.id from t_user_show c where c.show_id = t.show_id and c.do_type='2'and c.user_id = :user_id) As like_id,(select d.id from t_user_collection d where d.collection_id = t.show_id and d.collection_type='1' and d.user_id = :user_id ) As collection_id from t_data_show t where t.show_id=:show_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(HappyInfoShowVO);
		List<HappyInfoShow> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(HappyInfoShow.class));
		if(list != null && list.size()>0){
		updateSeeNum(list.get(0).getShow_id());
		}
		return list;
	}
	/**
	 * 增加查看数
	 * @return
	 */
	public int updateSeeNum(int showId) {
		HappyInfoShow happyInfoShow = new HappyInfoShow();
		happyInfoShow.setShow_id(showId);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "update t_data_show set read_num = read_num+1 where show_id = :show_id";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(happyInfoShow);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	public int deleteUserShow(int id,int user_id) {
		String sql = "delete from t_user_show where show_id=? and user_id=? and do_type = '2'";
		return jdbcTemplate.update(sql, id,user_id);
	}
	/**
	 * 收藏
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
	 * @return
	 */
	public int deleteCollection(int id,int user_id) {
		String sql = "delete from t_user_collection where collection_id=? and user_id=? and collection_type = '1'";
		return jdbcTemplate.update(sql, id,user_id);
	}

}
