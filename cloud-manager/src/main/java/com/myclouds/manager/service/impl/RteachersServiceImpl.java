package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RteachersMapper;
import com.myclouds.manager.mapper.RusersMapper;
import com.myclouds.manager.pojo.Rteachers;
import com.myclouds.manager.pojo.RteachersExample;
import com.myclouds.manager.pojo.Rusers;
import com.myclouds.manager.pojo.RusersExample;
import com.myclouds.manager.service.RteachersService;
import com.myclouds.manager.service.RusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RteachersServiceImpl implements RteachersService {

    @Autowired
    private RteachersMapper rteachersMapper;

    @Override
    public List<Rteachers> findAllRteachersSize() {
        return rteachersMapper.selectAllSize();
    }

    @Override
    public List<Rteachers> getAllRteachersList(Rteachers bean) {
        return rteachersMapper.selectAll(bean);
    }

    @Override
    public List<Rteachers> getRteachersByUid(Integer uid) {
        return rteachersMapper.selectById(uid);
    }

    @Override
    public List<Rteachers> getRteachersByBid(Integer uid) {
        RteachersExample example = new RteachersExample();
        example.createCriteria().andTubidEqualTo(uid);
        return rteachersMapper.selectByExample(example);
    }

    @Override
    public List<Rteachers> login(Rteachers bean) {
        RteachersExample example = new RteachersExample();
        example.createCriteria().andTuidsEqualTo(bean.getTuids())
                .andTupwdEqualTo(bean.getTupwd());
        return rteachersMapper.selectByExample(example);
    }

    @Override
    public List<Rteachers> findRteachersByTuids(String bean) {
        return rteachersMapper.selectByTuids(bean);
    }

    @Override
    public List<Rteachers> checkRteachers(Rteachers bean) {
        RteachersExample example = new RteachersExample();
        example.createCriteria().andTutelEqualTo(bean.getTutel())
                .andTuidsEqualTo(bean.getTuids())
                .andTubidEqualTo(bean.getTubid());
        return rteachersMapper.selectByExample(example);
    }

    @Override
    public List<Rteachers> findRteachersByFuzzyquerySize(Rteachers bean) {
        return rteachersMapper.selectAllByFuzzyquerySize(bean);
    }

    @Override
    public List<Rteachers> findRteachersByFuzzyquery(Rteachers bean) {
        return rteachersMapper.selectAllByFuzzyquery(bean);
    }

    @Override
    public void deleteRteachersById(Integer uid) {
        rteachersMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void updateRteachersInfo(Rteachers bean) {
        rteachersMapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void insert(Rteachers bean) {
        rteachersMapper.insertSelective(bean);
    }
}
