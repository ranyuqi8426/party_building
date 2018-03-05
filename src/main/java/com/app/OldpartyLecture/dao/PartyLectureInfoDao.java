package com.app.OldpartyLecture.dao;

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

import com.app.Oldlifecircle.model.UserCollection;
import com.app.Oldlogin.model.SysSign;
import com.app.OldpartyLecture.model.BookChapter;
import com.app.OldpartyLecture.model.BookText;
import com.app.OldpartyLecture.model.PartyLectureInfo;
import com.app.OldpartyLecture.model.StudyRecord;
import com.app.OldpartyLecture.vo.BookChapterVO;
import com.app.OldpartyLecture.vo.BookTextVO;
import com.app.OldpartyLecture.vo.PartyLectureInfoVO;
import com.app.util.page.PageUtil;

@Repository
public class PartyLectureInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PartyLectureInfo> list(PartyLectureInfoVO PartyLectureInfoVO) {
		String sql = "select t.*,(select b.id from t_user_collection b where b.collection_id = t.learning_data_id and b.collection_type='";
		if (PartyLectureInfoVO.getLearning_data_type() != null && PartyLectureInfoVO.getLearning_data_type().equals("3")) {
			sql += "3";
		}else if (PartyLectureInfoVO.getLearning_data_type() != null && PartyLectureInfoVO.getLearning_data_type().equals("2")) {
			sql += "5";
		}else if (PartyLectureInfoVO.getLearning_data_type() != null && PartyLectureInfoVO.getLearning_data_type().equals("1")) {
			sql += "4";
		}
		sql +=  " ' and b.user_id = :user_id ) As collection_id ,(select count(*) from t_user_learning a where a.learning_data_id = t.learning_data_id  ) As read_num from t_data_learn t where 1=1 and t.learning_data_type = :learning_data_type";
		sql += createSearchSql(PartyLectureInfoVO);
		sql += " order by t.create_date desc";
		sql = PageUtil.createMysqlPageSql(sql,PartyLectureInfoVO.getPage(),PartyLectureInfoVO.getLimit());
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(PartyLectureInfoVO);
		List<PartyLectureInfo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(PartyLectureInfo.class));
		return list;
	}
	
	/**
	 * 生成查询条件
	 */
	private String createSearchSql(PartyLectureInfoVO PartyLectureInfoVO) {
		String sql = "";
//	if (StringUtil.isNotNullOrEmpty(PartyLectureInfoVO.getBank_id())) {
//		sql += " and bank_id = :bank_id";
//	}

		return sql;
	}
	/**
	 * 新增学习记录
	 * @return
	 */
	public int addStudyRecord(PartyLectureInfoVO PartyLectureInfoVO) {
		StudyRecord studyRecord = new StudyRecord();
		studyRecord.setLearning_begin_time(new java.sql.Date(new Date().getTime()));
		studyRecord.setLearning_data_id(PartyLectureInfoVO.getLearning_data_id());
		studyRecord.setUser_id(Integer.parseInt(PartyLectureInfoVO.getUser_id()));
		studyRecord.setLearning_type(PartyLectureInfoVO.getLearning_type());
		studyRecord.setLearning_point(0);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String sql = "insert into t_user_learning (learning_data_id,user_id,learning_begin_time,learning_point,learning_type) values(:learning_data_id,:user_id,:learning_begin_time,:learning_point,:learning_type)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(studyRecord);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rc = namedParameterJdbcTemplate.update(sql,paramSource, keyHolder, new String[]{"id"});
		return keyHolder.getKey().intValue();
	}
	/**
	 * 更新学习记录
	 * @return
	 */
	public int updateStudyRecord(StudyRecord studyRecord) {
		String sql = "update t_user_learning set learning_end_time=:learning_end_time,learning_point=:learning_point  where id=:id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(studyRecord);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}
	/**
	 * 获取学习记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StudyRecord> getStudyRecord(int id) {
		String sql = "select t.* from t_user_learning t where t.id=?";
		Object[] params = new Object[] { id };
		List<StudyRecord> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(StudyRecord.class));
		return list;
	}
	/**
	 * 获取一条记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PartyLectureInfo> get(PartyLectureInfoVO PartyLectureInfoVO) {
		//理论知识
		PartyLectureInfoVO.setLearning_data_type("3");
		int rc = addStudyRecord(PartyLectureInfoVO);
		String sql = "select t.*,b.username as create_name,(select d.id from t_user_collection d where d.collection_id = t.learning_data_id and d.collection_type='3' and d.user_id = :user_id ) As collection_id from t_data_learn t,t_sys_user b where t.learning_data_id=:learning_data_id   and b.user_id = t.create_user_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(PartyLectureInfoVO);
		List<PartyLectureInfo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(PartyLectureInfo.class));
		if (list != null && list.size()>0) {
			list.get(0).setId(rc);
		}
		return list;
	}
	
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
	public int deleteCollection(int id, int user_id,String type) {
		String sql = "delete from t_user_collection where collection_id=? and user_id=? and collection_type = ?";
		return jdbcTemplate.update(sql, id, user_id,type);
	}

	
	/**
	 * 书章节查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BookChapter> addBook(BookChapterVO BookChapterVO) {
		String sql = "select t.* from t_data_book_chapter t where 1=1 and t.book_id = :book_id";
		sql += " order by t.chapter_id ";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BookChapterVO);
		List<BookChapter> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(BookChapter.class));
		return list;
	}
	
	/**
	 * 获取一条 书章节内容
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BookText>getBookContext(BookTextVO BookTextVO) {
		String sql = "select t.*,a.chapter_title from t_data_book_text t,t_data_book_chapter a where t.book_id = :book_id and t.chapter_id = :chapter_id and a.book_id =t.book_id and a.chapter_id = t.chapter_id";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(BookTextVO);
		List<BookText> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(BookText.class));
		
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getBookMainId(int id) {
		String sql = "select * from t_data_learn where learning_data_type = '2' and learning_data_url=?";
		Object[] params = new Object[] { id };
		List<PartyLectureInfo> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(PartyLectureInfo.class));
		if (list.size() > 0)
			return list.get(0).getLearning_data_id();
		else
			return 0;
	}
}
