package com.app.party.service;

import com.app.party.dao.PartySingleDao;
import com.app.party.model.PartySingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiNan on 2018-03-07.
 * Description:
 */
@Service
public class PartySingleService {
    @Autowired
    private PartySingleDao partySingleDao;
    
    public List<PartySingle> list(String build_id, String user_id, int kinds) {
        return partySingleDao.list(build_id,user_id,kinds);
    }

    public PartySingle getOne(String partySinge_id, int kinds) {
        return partySingleDao.getOne(partySinge_id,kinds);
    }

    public int add(PartySingle partySingle, int kinds) {
        return partySingleDao.add(partySingle,kinds);
    }

    public int update(PartySingle partySingle, int kinds) {
        return partySingleDao.update(partySingle,kinds);
    }

    public int delete(String party_single_id, int kinds) {
        return partySingleDao.delete(party_single_id,kinds);
    }
}
