package com.app.livecircle.dao;

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

import com.app.livecircle.model.Wish;
import com.app.livecircle.model.WishStatus;
import com.app.util.page.PageUtil;


@Repository
public class WishDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param wish_type 心愿状态（0、未认领 1、已认领）
	 * @param pageSize
	 * @return
	 */
	public List<Wish> list(String wish_type,int pageSize) {
		String sql = "select *,(select b.user_nicknm from t_sys_user b where b.user_id = t.create_cd ) as create_name from bns_wish t left join bns_wish_status a on t.wish_id = a.wish_id  "
				+ " where  t.wish_type=?  and  "
				+ " a.wish_status_nm = '2'  "
				+ " order by t.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] { wish_type };
		List<Wish> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Wish.class));
		return list;
	}
	
	
	/**
	 * 心愿详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Wish get(String list_id) {
		String sql = "select *,(select b.user_nicknm from t_sys_user b where b.user_id = t.create_cd ) as create_name from bns_wish t where t.wish_id = ? ";
		Object[] params = new Object[] { list_id };
		List<Wish> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Wish.class));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	/**
	 * 心愿状态详情
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<WishStatus> getWishStatus(String list_id) {
		String sql = "select * from bns_wish_status t where t.wish_id = ? order by t.wish_status_nm";
		Object[] params = new Object[] { list_id };
		List<WishStatus> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(WishStatus.class));
			return list;
	}
	
	/**
	 * 新建心愿
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param informationLike
	 */
	public int add(Wish wish) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_wish (wish_name,wish_content,wish_story,wish_thank,wish_type,wish_username,wish_phone,wish_img1,wish_img2,wish_img3,wish_imgnum,create_cd)";
		sql += " values(:wish_name,:wish_content,:wish_story,:wish_thank,:wish_type,:wish_username,:wish_phone,:wish_img1,:wish_img2,:wish_img3,:wish_imgnum,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(wish);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql, paramSource,keyHolder);
		int wish_id = 0;
		if (rc > 0) {
			wish_id = keyHolder.getKey().intValue();
		}
		return wish_id;
	}
	/**
	 * 新建心愿状态
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param 
	 */
	public int addWishStatus(WishStatus wishStatus) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into bns_wish_status (wish_id,wish_status_cd,wish_status_nm,create_cd)";
		sql += " values(:wish_id,:wish_status_cd,:wish_status_nm,:create_cd)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(wishStatus);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 认领心愿
	 * @author 冉玉琦
	 * @date 2018年3月21日
	 * @param wish_id
	 * @return
	 */
	public int update(int wish_id) {
		String sql="update bns_wish  set wish_type= 1 where wish_id = ? ";
		return jdbcTemplate.update(sql,wish_id);
	}
	/**********************************************************************  我的心愿   **********************************************************************/
	/**
	 * 我的 心愿列表查询
	 * @author 冉玉琦
	 * @date 2018年3月2日
	 * @param pageSize 
	 * wish_status_nm（wish_status_nm） 1创建（发布）   2审核3审核不通过   4完成(认领)
	 * @return
	 */
	public List<Wish> listMy(String user_id,String wish_status_nm,int pageSize) {
		String sql = "select *,(select b.user_nicknm from t_sys_user b where b.user_id = t.create_cd ) as create_name from bns_wish t , bns_wish_status a where t.wish_id = a.wish_id  "
				+ "  and  a.create_cd = ? "
				+ "  and a.wish_status_nm = ?  "
				+ " order by a.create_time desc ";
		sql = PageUtil.createMysqlPageSql(sql,pageSize, 3);
		Object[] params = new Object[] {user_id, wish_status_nm };
		List<Wish> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Wish.class));
		return list;
	}

}
