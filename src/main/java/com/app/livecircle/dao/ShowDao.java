package com.app.livecircle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.livecircle.model.Show;
import com.app.livecircle.model.ShowLike;
import com.app.livecircle.model.ShowMessage;
import com.app.util.page.PageUtil;


@Repository
public class ShowDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 晒晒列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<Show> list(String user_id,int pageSize) {
		String sql = " select t.*,d.head_img_url,d.user_name,"
				+ " (select a.show_like_id from bns_show_like a where a.show_id = t.show_id and a.create_cd = ?) as show_like_id,"
				+ " (select count(*) from bns_show_like b where b.show_id = t.show_id ) as like_num,"
				+ " (select count(*) from bns_show_message c where c.show_id = t.show_id ) as say_num  "
				+ "  from bns_show t left join t_sys_user d "
				+ "  on t.create_cd = d.user_id  "
				+ " where t.show_status= 2 order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { user_id };
		List<Show> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Show.class));
		return list;
	}
	
	/**
	 * 点赞
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int addLike(ShowLike showLike) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_show_like(show_id,create_cd)";
		sql += " values(:show_id,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(showLike);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 取消点赞
	 * @return
	 */
	public int deleteLike(int id,int user_id) {
		String sql = "delete from bns_show_like where show_id=? and create_cd=? ";
		return jdbcTemplate.update(sql, id,user_id);
	}
	/**
	 * 评论
	 * @author 冉玉琦
	 * @date 2018年3月22日
	 * @param showMessage
	 * @return
	 */
	public int addSay(ShowMessage showMessage) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_show_message(show_id,show_message,create_cd)";
		sql += " values(:show_id,:show_message,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(showMessage);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 新增
	 * @author 冉玉琦
	 * @date 2018年3月22日
	 * @param show
	 * @return
	 */
	public int add(Show show) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_show(show_content,show_status,show_img1,show_img2,show_img3,show_num,show_position,create_cd)";
		sql += " values(:show_content,:show_status,:show_img1,:show_img2,:show_img3,:show_num,:show_position,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(show);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**************************************************************** 我的晒晒  **********************************************************************************/
	/**
	 * 我的 晒晒列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public List<Show> listMy(String user_id,int pageSize) {
		String sql = " select t.*"
				+ "  from bns_show t "
				+ " where 1=1"
//				+ " and t.show_status= 2 "
				+ " and t.create_cd = ? "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { user_id };
		List<Show> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Show.class));
		return list;
	}
	/**
	 * 我的 晒晒详情查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param floorid
	 * @param pageSize
	 * @return
	 */
	public Show getMy(String user_id,String show_id) {
		String sql = " select t.*, "
				+ " (select a.show_like_id from bns_show_like a where a.show_id = t.show_id and a.create_cd = ?) as show_like_id,"
				+ " (select count(*) from bns_show_like b where b.show_id = t.show_id ) as like_num,"
				+ " (select count(*) from bns_show_message c where c.show_id = t.show_id ) as say_num  "
				+ "  from bns_show t  "
				+ " where 1=1"
//				+ " and t.show_status= 2 "
				+ " and t.show_id = ?";
		Object[] params = new Object[] { user_id,show_id };
		List<Show> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Show.class));
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
