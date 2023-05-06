package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RdailyclocksMapper;
import com.myclouds.manager.mapper.RholidaysMapper;
import com.myclouds.manager.pojo.Rdailyclocks;
import com.myclouds.manager.pojo.RdailyclocksExample;
import com.myclouds.manager.pojo.Rholidays;
import com.myclouds.manager.pojo.RholidaysExample;
import com.myclouds.manager.service.RdailyclocksService;
import com.myclouds.manager.service.RholidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RholidaysServiceImpl implements RholidaysService {

    @Autowired
    private RholidaysMapper rholidaysMapper;

    @Override
    public List<Rholidays> checkholidays(Rholidays record) {
        return rholidaysMapper.checkholidays(record);
    }

    @Override
    public List<Rholidays> selectAllSize() {
        return rholidaysMapper.selectAllSize();
    }

    @Override
    public List<Rholidays> selectAll(Rholidays record) {
        return rholidaysMapper.selectAll(record);
    }

    @Override
    public List<Rholidays> selectById(Integer hid) {
        return rholidaysMapper.selectById(hid);
    }

    @Override
    public List<Rholidays> selectByFlag(Integer hid) {
        return rholidaysMapper.selectByFlag(hid);
    }

    @Override
    public List<Rholidays> selectAllByUidSize(Rholidays record) {
        return rholidaysMapper.selectAllByUidSize(record);
    }

    @Override
    public List<Rholidays> selectAllByUidAndFlag(Rholidays record) {
        return rholidaysMapper.selectAllByUidAndFlag(record);
    }

    @Override
    public List<Rholidays> selectAllByUid(Rholidays record) {
        return rholidaysMapper.selectAllByUid(record);
    }

    @Override
    public List<Rholidays> selectAllByTidSize(Rholidays record) {
        return rholidaysMapper.selectAllByTidSize(record);
    }

    @Override
    public List<Rholidays> selectAllByTidAndFlag(Rholidays record) {
        return rholidaysMapper.selectAllByTidAndFlag(record);
    }

    @Override
    public List<Rholidays> selectAllByTid(Rholidays record) {
        return rholidaysMapper.selectAllByTid(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyquerySize(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyquerySize(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyquery(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyquery(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyqueryByUidSize(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyqueryByUidSize(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyqueryByUid(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyqueryByUid(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyqueryByTidSize(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyqueryByTidSize(record);
    }

    @Override
    public List<Rholidays> selectAllByFuzzyqueryByTid(Rholidays record) {
        return rholidaysMapper.selectAllByFuzzyqueryByTid(record);
    }

    @Override
    public void updateRholidaysInfo(Rholidays bean) {
        rholidaysMapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void insertRholidaysInfo(Rholidays bean) {
        rholidaysMapper.insertSelective(bean);
    }

    @Override
    public void deleteRholidaysById(Integer id) {
        rholidaysMapper.deleteByPrimaryKey(id);
    }
}
