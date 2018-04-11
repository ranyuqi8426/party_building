package com.app.livecircle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.livecircle.model.Aboutactivity;
import com.app.livecircle.model.AboutactivityType;
import com.app.livecircle.model.AboutactivityTypeRelation;
import com.app.livecircle.model.AboutactivityUser;
import com.app.userwork.model.Collection;
import com.app.util.page.PageUtil;
import com.app.util.string.StringUtil;


@Repository
public class AboutactivityDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 约吧活动类型查询
	 * @param request
	 * @param response
	 */
	public List<AboutactivityType> listType() {
		String sql = "select * from bns_aboutactivity_type t  "
				+ " order by t.sort_num ";
		Object[] params = new Object[] {};
		List<AboutactivityType> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AboutactivityType.class));
		return list;
	}

	/**
	 * 约吧活动类型私人订制查询
	 * @param request
	 * @param response
	 */
	public List<AboutactivityTypeRelation> listTypeRelation(String user_id) {
		String sql = "select * from bns_aboutactivity_typerelation t , bns_aboutactivity_type a "
				+ " where  a.aboutactivity_type_id = t.aboutactivity_type_id "
				+ " and t.user_id=?   "
				+ " order by t.create_time desc ";
		Object[] params = new Object[] {user_id};
		List<AboutactivityTypeRelation> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(AboutactivityTypeRelation.class));
		return list;
	}
	/**
	 * 约吧活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param flooractivity_status 活动状态活动状态(1未审核 2审核通过 3审核未通过)
	 * @param pageSize
	 * @return
	 */
	public List<Aboutactivity> list(String floor_id,String aboutactivity_type,int pageSize) {
		String sql = "select * from bns_aboutactivity t  ";
				sql += " where  1=1 ";
				if(!StringUtil.isNullOrEmpty(aboutactivity_type)){
					sql += " and t.aboutactivity_type="+aboutactivity_type;
				}
				sql += " and t.floor_id = ?  ";
				sql += " and t.aboutactivity_status = '2' ";
				sql += " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { floor_id };
		List<Aboutactivity> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Aboutactivity.class));
		return list;
	}
	
	/**
	 * 约吧活动详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Aboutactivity get(String user_id,String list_id) {
		String sql = "select t.*,"
				+ " (select a.collection_id  from bns_collection a where a.collection_content_type = '1' and a.collection_content_id = t.aboutactivity_id and a.user_id = ? ) as collection_id "
				+ " from bns_aboutactivity t where t.aboutactivity_id = ? ";
		Object[] params = new Object[] { user_id,list_id };
		List<Aboutactivity> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Aboutactivity.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	/**
	 * 约吧活动参与人详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AboutactivityUser> getAboutactivityUser(String user_id,int list_id) {
		String sql = "select t.* "
				+ " from bns_aboutactivity_relation t where t.create_cd = ? and t.activity_id = ? ";
		Object[] params = new Object[] { user_id,list_id };
		List<AboutactivityUser> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(AboutactivityUser.class));
			return list;
	}
	
	/**
	 * 收藏
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param 
	 */

	public int addLike(Collection collection) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_collection (user_id,collection_content_id,collection_content,collection_content_type,collection_content_url,create_cd)";
		sql += " values(:user_id,:collection_content_id,:collection_content,:collection_content_type,:collection_content_url,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(collection);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 取消收藏
	 * @return
	 */
	public int deleteLike(String list_id,int user_id,String type) {
		String sql = "delete from bns_collection where collection_content_id=? and user_id=? and collection_content_type =? ";
		return jdbcTemplate.update(sql, list_id,user_id,type);
	}
	/**
	 * 参与活动
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUser
	 * @return
	 */
	public int addUser(AboutactivityUser aboutactivityUser) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_aboutactivity_relation (activity_id,name,company,phone,create_cd)";
		sql += " values(:activity_id,:name,:company,:phone,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(aboutactivityUser);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	/**
	 * 新增私人订制
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUser
	 * @return
	 */
	public int addTypeRelation(AboutactivityTypeRelation aboutactivityTypeRelation) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_aboutactivity_relation (activity_id,name,company,phone,create_cd)";
		sql += " values(:activity_id,:name,:company,:phone,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(aboutactivityTypeRelation);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 *  约吧活动类型私人订制清空
	 * @return
	 */
	public int deleteTypeRelation(String user_id) {
		String sql = "delete from bns_aboutactivity_typerelation where user_id=? ";
		return jdbcTemplate.update(sql, user_id);
	}
	/**
	 * 新建活动
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 */
	public int add(Aboutactivity aboutactivity) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_aboutactivity (floor_id,aboutactivity_name,aboutactivity_start_time,aboutactivity_end_time,aboutactivity_num,aboutactivity_content,aboutactivity_type,aboutactivity_status,come_num,aboutactivity_img,create_cd)";
		sql += " values(:floor_id,:aboutactivity_name,:aboutactivity_start_time,:aboutactivity_end_time,:aboutactivity_num,:aboutactivity_content,:aboutactivity_type,:aboutactivity_status,:come_num,:aboutactivity_img,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(aboutactivity);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 修改参加人数
	 * @return
	 */
	public int updateComeNum(int activity_id) {
		String sql = "update bns_aboutactivity set come_num = come_num +1  where aboutactivity_id = ? ";
		return jdbcTemplate.update(sql,activity_id);
	}
	/**
	 * 我的 活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * 活动类型 1我发布
	 * @return
	 */
	public List<Aboutactivity> listMyFor1(String user_id, int pageSize) {
		String sql = "select * from bns_aboutactivity t  "
				+ " where  t.create_cd=?   "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {user_id };
		List<Aboutactivity> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Aboutactivity.class));
		return list;
	}
	/**
	 * 我的 活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * 活动类型  2 我参与
	 * @return
	 */
	public List<Aboutactivity> listMyFor2(String user_id, int pageSize) {
		String sql = "select * from bns_aboutactivity t,bns_aboutactivity_relation a  "
				+ " where  t.aboutactivity_id=a.activity_id   "
				+ " and t.create_cd = ?  "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {user_id };
		List<Aboutactivity> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Aboutactivity.class));
		return list;
	}
}
