package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RknowledgesMapper;
import com.myclouds.manager.mapper.RnewsMapper;
import com.myclouds.manager.pojo.Rknowledges;
import com.myclouds.manager.pojo.RknowledgesExample;
import com.myclouds.manager.pojo.Rnews;
import com.myclouds.manager.pojo.RnewsExample;
import com.myclouds.manager.service.RknowledgesService;
import com.myclouds.manager.service.RnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RknowledgesServiceImpl implements RknowledgesService {

    @Autowired
    private RknowledgesMapper knowledgesMapper;

    @Override
    public List<Rknowledges> findAllKnowledgesSize() {
        return knowledgesMapper.findAllKnowledgesSize();
    }

    @Override
    public List<Rknowledges> getAllKnowledgesList(Rknowledges bean) {
        return knowledgesMapper.findAllKnowledges(bean);
    }

    @Override
    public List<Rknowledges> getKnowledgesById(Integer id) {
        return knowledgesMapper.findKnowledgesByKid(id);
    }

    @Override
    public List<Rknowledges> findKnowledgesByFuzzyquerySize(Rknowledges bean) {
        return knowledgesMapper.findAllKnowledgesByFuzzyquerySize(bean);
    }

    @Override
    public List<Rknowledges> findKnowledgesByFuzzyquery(Rknowledges bean) {
        return knowledgesMapper.findAllKnowledgesByFuzzyquery(bean);
    }

    @Override
    public List<Rknowledges> checkKnowledges(String name) {
        RknowledgesExample example = new RknowledgesExample();
        example.createCriteria().andRktitleEqualTo(name);
        return knowledgesMapper.selectByExample(example);
    }

    @Override
    public void updateKnowledgesInfo(Rknowledges bean) {
        knowledgesMapper.updateByPrimaryKeySelective(bean);
    }

    @Override
    public void insertKnowledgesInfo(Rknowledges bean) {
        knowledgesMapper.insertSelective(bean);
    }

    @Override
    public void deleteKnowledgesById(Integer id) {
        knowledgesMapper.deleteByPrimaryKey(id);
    }
}
