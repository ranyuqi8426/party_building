package com.app.userwork.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.app.userwork.model.Collection;
import com.app.userwork.vo.CollectionVO;
import com.app.util.page.PageUtil;
@Repository
public class CollectionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * 查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Collection> list(CollectionVO CollectionVO) {
		String sql = "select * from t_data_show a,t_user_collection b where ";
		sql += " a.show_id = b.collection_id and a.audit_status = '1' and b.collection_type = '1'  " ;
		sql +=" and b.user_id = :user_id ";
		sql += createSearchSql(CollectionVO);
		sql += " order by b.create_date desc";
		sql = PageUtil.createMysqlPageSql(sql,CollectionVO.getPage(),CollectionVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(CollectionVO);
		List<Collection> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(Collection.class));
		return list;
	}
//	
//	
//
//
//	/**
//	 * 获取一条记录
//	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public List<Collection> get(String id,String uid) {
//		String sql = "select t.*,(select count(*) from t_user_activity a where a.activity_id = t.activity_id and a.user_id = '"+uid+"') as user_id  from t_data_activity t where t.activity_id=?";
//		Object[] params = new Object[] { id };
//		List<Collection> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Collection.class));
//		return list;
//	}
	
	/**
	 * 删除
	 * @return
	 */
	public int delete(String id) {
		String sql = "delete from t_user_collection where id=? ";
		return jdbcTemplate.update(sql, id);
	}
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(CollectionVO CollectionVO) {
		String sql = "";
//	if (StringUtil.isNotNullOrEmpty(CollectionVO.getBank_id())) {
//		sql += " and bank_id = :bank_id";
//	}

		return sql;
	}

}
