package com.app.livecircle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.livecircle.model.Building;
import com.app.livecircle.model.BuildingUser;
import com.app.livecircle.model.BuildingUserSay;
import com.app.userwork.model.Collection;
import com.app.util.page.PageUtil;


@Repository
public class BuildingDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 楼宇活动列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param flooractivity_status 活动状态（0未发布1已发布）
	 * @param pageSize
	 * @return
	 */
	public List<Building> list(String floor_id,String flooractivity_type,int pageSize) {
		String sql = "select * from bns_flooractivity t  "
				+ " where  t.flooractivity_type=?   "
				+ " and t.floor_id = ?  "
				+ " and t.flooractivity_status = '1' "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {flooractivity_type, floor_id };
		List<Building> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Building.class));
		return list;
	}
	
	
	/**
	 * 楼宇活动详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Building get(String user_id,String list_id) {
		String sql = "select t.*,"
				+ " (select a.collection_id  from bns_collection a where a.collection_content_type = '1' and a.collection_content_id = t.flooractivity_id and a.user_id = ? ) as collection_id "
				+ " from bns_flooractivity t where t.flooractivity_id = ? ";
		Object[] params = new Object[] { user_id,list_id };
		List<Building> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Building.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * 楼宇活动参与人列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	public List<BuildingUser> getUserList(String list_id) {
		String sql = "select * from bns_flooractivity_relation t ,t_sys_user a"
				+ " where  t.create_cd = a.user_id "
				+ " and t.flooractivity_id=?   "
				+ " order by t.create_time desc ";
		Object[] params = new Object[] {list_id };
		List<BuildingUser> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(BuildingUser.class));
		return list;
	}

	/**
	 * 楼宇活动评论列表详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param request
	 * @param response
	 */
	public List<BuildingUserSay> getUserSayList(String list_id,int pageSize) {
		String sql = "select * from bns_flooractivity_message t ,t_sys_user a"
				+ " where  t.create_cd = a.user_id "
				+ " and t.flooractivity_id=?   "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {list_id };
		List<BuildingUserSay> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(BuildingUserSay.class));
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
	public int addUser(BuildingUser buildingUser) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_flooractivity_relation (flooractivity_id,name,phone,company,mailbox,create_cd)";
		sql += " values(:flooractivity_id,:name,:phone,:company,:mailbox,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(buildingUser);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param buildingUserSay
	 * @return
	 */
	public int addUserSay(BuildingUserSay buildingUserSay) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_flooractivity_message (flooractivity_id,flooractivity_message,create_cd)";
		sql += " values(:flooractivity_id,:flooractivity_message,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(buildingUserSay);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

}
