package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RdailyclocksMapper;
import com.myclouds.manager.mapper.RnewsMapper;
import com.myclouds.manager.pojo.Rdailyclocks;
import com.myclouds.manager.pojo.RdailyclocksExample;
import com.myclouds.manager.pojo.Rnews;
import com.myclouds.manager.pojo.RnewsExample;
import com.myclouds.manager.service.RdailyclocksService;
import com.myclouds.manager.service.RnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RdailyclocksServiceImpl implements RdailyclocksService {

    @Autowired
    private RdailyclocksMapper rdailyclocksMapper;

    @Override
    public List<Rdailyclocks> findDatasForEcharts(Rdailyclocks record) {
        return rdailyclocksMapper.selectDatasForEcharts(record);
    }

    @Override
    public List<Rdailyclocks> findTeacherDatasForEcharts(Rdailyclocks record) {
        return rdailyclocksMapper.selectTeacherDatasForEcharts(record);
    }

    @Override
    public List<Rdailyclocks> findAllRdailyclocksSize() {
        return rdailyclocksMapper.selectAllSize();
    }

    @Override
    public List<Rdailyclocks> getAllRdailyclocksList(Rdailyclocks bean) {
        return rdailyclocksMapper.selectAll(bean);
    }

    @Override
    public List<Rdailyclocks> getRdailyclocksById(Integer id) {
        return rdailyclocksMapper.selectById(id);
    }

    @Override
    public List<Rdailyclocks> getRdailyclocksByUidSize(Integer uid) {
        return rdailyclocksMapper.selectByUidSize(uid);
    }

    @Override
    public List<Rdailyclocks> getRdailyclocksByUid(Rdailyclocks bean) {
        return rdailyclocksMapper.selectByUid(bean);
    }

    @Override
    public List<Rdailyclocks> findRdailyclocksByFuzzyquerySize(Rdailyclocks bean) {
        return rdailyclocksMapper.selectAllByFuzzyquerySize(bean);
    }

    @Override
    public List<Rdailyclocks> findRdailyclocksByFuzzyquery(Rdailyclocks bean) {
        return rdailyclocksMapper.selectAllByFuzzyquery(bean);
    }

    @Override
    public List<Rdailyclocks> findRdailyclocksByFuzzyqueryByUidSize(Rdailyclocks bean) {
        return rdailyclocksMapper.selectAllByFuzzyqueryByUidSize(bean);
    }

    @Override
    public List<Rdailyclocks> findRdailyclocksByFuzzyqueryByUid(Rdailyclocks bean) {
        return rdailyclocksMapper.selectAllByFuzzyqueryByUid(bean);
    }

    @Override
    public List<Rdailyclocks> selectAllByFuzzyqueryByBidSize(Rdailyclocks record) {
        return rdailyclocksMapper.selectAllByFuzzyqueryByBidSize(record);
    }

    @Override
    public List<Rdailyclocks> selectAllByFuzzyqueryByBid(Rdailyclocks record) {
        return rdailyclocksMapper.selectAllByFuzzyqueryByBid(record);
    }

    @Override
    public List<Rdailyclocks> checkRdailyclocks(Rdailyclocks bean) {
        RdailyclocksExample example = new RdailyclocksExample();
        example.createCriteria().andPuidEqualTo(bean.getPuid()).andPdateEqualTo(bean.getPdate());
        return rdailyclocksMapper.selectByExample(example);
    }

    @Override
    public List<Rdailyclocks> selectByBidSize(Integer id) {
        return rdailyclocksMapper.selectByBidSize(id);
    }

    @Override
    public List<Rdailyclocks> selectByBid(Rdailyclocks record) {
        return rdailyclocksMapper.selectByBid(record);
    }

    @Override
    public void updateRdailyclocksInfo(Rdailyclocks bean) {
        rdailyclocksMapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void insertRdailyclocksInfo(Rdailyclocks bean) {
        rdailyclocksMapper.insertSelective(bean);
    }

    @Override
    public void deleteRdailyclocksById(Integer id) {
        rdailyclocksMapper.deleteByPrimaryKey(id);
    }
}
