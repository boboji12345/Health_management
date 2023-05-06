package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RclasssMapper;
import com.myclouds.manager.mapper.RclocknotificatsMapper;
import com.myclouds.manager.pojo.Rclasss;
import com.myclouds.manager.pojo.RclasssExample;
import com.myclouds.manager.pojo.Rclocknotificats;
import com.myclouds.manager.service.RclasssService;
import com.myclouds.manager.service.RclocknotificatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RclocknotificatsServiceImpl implements RclocknotificatsService {

    @Autowired
    private RclocknotificatsMapper rclocknotificatsMapper;

    @Override
    public List<Rclocknotificats> selectAllSize() {
        return rclocknotificatsMapper.selectAllSize();
    }

    @Override
    public List<Rclocknotificats> selectAll(Rclocknotificats record) {
        return rclocknotificatsMapper.selectAll(record);
    }

    @Override
    public List<Rclocknotificats> selectById(Integer nid) {
        return rclocknotificatsMapper.selectById(nid);
    }

    @Override
    public List<Rclocknotificats> finddatasbycurrdates(String currdate) {
        return rclocknotificatsMapper.finddatasbycurrdates(currdate);
    }

    @Override
    public List<Rclocknotificats> checkdatas(Rclocknotificats record) {
        return rclocknotificatsMapper.checkdatas(record);
    }

    @Override
    public List<Rclocknotificats> selectAllFuzzyquery(Rclocknotificats record) {
        return rclocknotificatsMapper.selectAllFuzzyquery(record);
    }

    @Override
    public List<Rclocknotificats> selectAllFuzzyquerySize(Rclocknotificats record) {
        return rclocknotificatsMapper.selectAllFuzzyquerySize(record);
    }

    @Override
    public List<Rclocknotificats> selectByDate(String bean) {
        return rclocknotificatsMapper.selectByDate(bean);
    }

    @Override
    public void updateRclocknotificatsInfo(Rclocknotificats bean) {
        rclocknotificatsMapper.updateByPrimaryKey(bean);
    }

    @Override
    public void insertRclocknotificatsInfo(Rclocknotificats bean) {
        rclocknotificatsMapper.insert(bean);
    }

    @Override
    public void deleteRclocknotificatsById(Integer id) {
        rclocknotificatsMapper.deleteByPrimaryKey(id);
    }
}
