package com.app.information.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.information.model.InformationLike;
import com.app.information.model.information;
import com.app.util.page.PageUtil;


@Repository
public class InformationDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 新闻资讯列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<information> list(String floorid,int pageSize) {
		String sql = "select t.* from bns_news t where t.floor_id=? order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { floorid };
		List<information> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(information.class));
		return list;
	}
	
	
	/**
	 * 新闻资讯详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public information get(String user_id,String list_id) {
		Object[] params = null;
		String sql = "";
		if(user_id == null||user_id.equals("")){
			sql = "select t.* from bns_news t where t.news_id=? ";
			params = new Object[] { list_id };
			
		}else{
			sql = "select t.*,(select count(*) from bns_news_like a where a.news_id = t.news_id and a.create_cd = ?) as isLike from bns_news t where t.news_id=? ";
			params = new Object[] { user_id,list_id };
			
		}
		List<information> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(information.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	/**
	 * 点赞
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int addLike(InformationLike informationLike) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_news_like(news_id,create_cd)";
		sql += " values(:news_id,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(informationLike);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	public int deleteLike(int id,int user_id) {
		String sql = "delete from bns_news_like where news_id=? and create_cd=? ";
		return jdbcTemplate.update(sql, id,user_id);
	}

	


}
