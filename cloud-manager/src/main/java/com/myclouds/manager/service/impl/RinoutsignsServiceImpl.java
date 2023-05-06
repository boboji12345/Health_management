package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RinoutsignsMapper;
import com.myclouds.manager.mapper.RinoutsignsMapper;
import com.myclouds.manager.pojo.Rinoutsigns;
import com.myclouds.manager.pojo.RinoutsignsExample;
import com.myclouds.manager.service.RinoutsignsService;
import com.myclouds.manager.service.RinoutsignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RinoutsignsServiceImpl implements RinoutsignsService {

    @Autowired
    private RinoutsignsMapper rinoutsignsMapper;

    @Override
    public List<Rinoutsigns> findAllRinoutsignsSize() {
        return rinoutsignsMapper.selectAllSize();
    }

    @Override
    public List<Rinoutsigns> getAllRinoutsignsList(Rinoutsigns bean) {
        return rinoutsignsMapper.selectAll(bean);
    }

    @Override
    public List<Rinoutsigns> getRinoutsignsById(Integer id) {
        return rinoutsignsMapper.selectById(id);
    }

    @Override
    public List<Rinoutsigns> getRinoutsignsByUidSize(Integer uid) {
        return rinoutsignsMapper.selectByUidSize(uid);
    }

    @Override
    public List<Rinoutsigns> getRinoutsignsByUid(Rinoutsigns bean) {
        return rinoutsignsMapper.selectByUid(bean);
    }

    @Override
    public List<Rinoutsigns> selectByBidSize(Integer id) {
        return rinoutsignsMapper.selectByBidSize(id);
    }

    @Override
    public List<Rinoutsigns> selectByBid(Rinoutsigns record) {
        return rinoutsignsMapper.selectByBid(record);
    }

    @Override
    public List<Rinoutsigns> findRinoutsignsByFuzzyquerySize(Rinoutsigns bean) {
        return rinoutsignsMapper.selectAllByFuzzyquerySize(bean);
    }

    @Override
    public List<Rinoutsigns> findRinoutsignsByFuzzyquery(Rinoutsigns bean) {
        return rinoutsignsMapper.selectAllByFuzzyquery(bean);
    }

    @Override
    public List<Rinoutsigns> findRinoutsignsByFuzzyqueryByUidSize(Rinoutsigns bean) {
        return rinoutsignsMapper.selectAllByFuzzyqueryByUidSize(bean);
    }

    @Override
    public List<Rinoutsigns> findRinoutsignsByFuzzyqueryByUid(Rinoutsigns bean) {
        return rinoutsignsMapper.selectAllByFuzzyqueryByUid(bean);
    }

    @Override
    public void updateRinoutsignsInfo(Rinoutsigns bean) {
        rinoutsignsMapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void insertRinoutsignsInfo(Rinoutsigns bean) {
        rinoutsignsMapper.insertSelective(bean);
    }

    @Override
    public void deleteRinoutsignsById(Integer id) {
        rinoutsignsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Rinoutsigns> selectAllByFuzzyqueryByBidSize(Rinoutsigns record) {
        return rinoutsignsMapper.selectAllByFuzzyqueryByBidSize(record);
    }

    @Override
    public List<Rinoutsigns> selectAllByFuzzyqueryByBid(Rinoutsigns record) {
        return rinoutsignsMapper.selectAllByFuzzyqueryByBid(record);
    }
}
