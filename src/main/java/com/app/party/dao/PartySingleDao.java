package com.app.party.dao;

import com.app.party.model.PartySingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-03-07.
 * Description:
 */
@Repository
public class PartySingleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 生成查询条件
     */
    private String createSearchSql(int kinds) {
        String table ="";
        if (kinds == 1){
            table = "PartySingleJS t";
        }else if (kinds == 2){
            table = "PartySingleFW t";
        }else if (kinds == 3){
            table = "PartySingleFG t";
        }
        return table;
    }

    public List<PartySingle> list(String build_id, String user_id, int kinds) {
        String sql = "select t.* from "+ createSearchSql(kinds) + "where t.BUILD_ID =? and t.CREATE_USER_ID =?";
        Object[] params = new Object[] {build_id,user_id };
        List<PartySingle> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartySingle.class));
        return list;
    }

    public PartySingle getOne(String partySinge_id, int kinds) {
        String sql = "select t.* from "+ createSearchSql(kinds) + "where t.PARTY_SINGLE_ID =?";
        Object[] params = new Object[] {partySinge_id};
        List<PartySingle> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PartySingle.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public int add(PartySingle partySingle, int kinds) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into " + createSearchSql(kinds) +
                "(party_single_title,party_single_time,party_single_content,party_single_place,party_single_pic1,party_single_pic2,party_single_status,build_id,create_user_id,create_time)";
        sql += " values(:party_single_title,:party_single_time,:party_single_content,:party_single_place,:party_single_pic1,:party_single_pic2,:party_single_status,:build_id,:create_user_id,:create_time)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partySingle);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int update(PartySingle partySingle, int kinds) {
        String sql = "update" + createSearchSql(kinds) +
                " set party_single_title=:party_single_title,party_single_time=:party_single_time,party_single_content=:party_single_content,party_single_place=:party_single_place,party_single_pic1=:party_single_pic1,party_single_pic2=:party_single_pic2,party_single_status=:party_single_status,build_id=:build_id,update_user_id=:update_user_id,update_time=:update_time)";
        sql+= " where party_single_id=:party_single_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(partySingle);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int delete(String party_single_id, int kinds) {
        String sql = "delete from "+ createSearchSql(kinds) + "party_single_id=?";
        return jdbcTemplate.update(sql, party_single_id);
    }
}
