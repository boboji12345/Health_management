package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RnewsMapper;
import com.myclouds.manager.pojo.Rnews;
import com.myclouds.manager.pojo.RnewsExample;
import com.myclouds.manager.service.RnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RnewsServiceImpl implements RnewsService {

    @Autowired
    private RnewsMapper newsMapper;

    @Override
    public List<Rnews> findAllNewsSize() {
        return newsMapper.findAllNewsSize();
    }

    @Override
    public List<Rnews> getAllNewsList(Rnews bean) {
        return newsMapper.findAllNews(bean);
    }

    @Override
    public List<Rnews> getAllNewsList10() {
        RnewsExample example = new RnewsExample();
        example.setOrderByClause(" rnid desc");
        List<Rnews> newsWts = newsMapper.selectByExampleWithBLOBs(example)
                .stream().limit(10).collect(Collectors.toList());
        return newsWts;
    }

    @Override
    public List<Rnews> getNewsById(Integer id) {
        return newsMapper.findNewsByNid(id);
    }

    @Override
    public List<Rnews> findNewsByFuzzyquerySize(Rnews bean) {
        return newsMapper.findAllNewsByFuzzyquerySize(bean);
    }

    @Override
    public List<Rnews> findNewsByFuzzyquery(Rnews bean) {
        return newsMapper.findAllNewsByFuzzyquery(bean);
    }

    @Override
    public List<Rnews> checkNews(String gname) {
        RnewsExample example = new RnewsExample();
        example.createCriteria().andRntitleEqualTo(gname);
        return newsMapper.selectByExample(example);
    }

    @Override
    public void updateNewsInfo(Rnews News) {
        newsMapper.updateByPrimaryKeySelective(News);
    }

    @Override
    public void insertNewsInfo(Rnews News) {
        newsMapper.insertSelective(News);
    }

    @Override
    public void deleteNewsById(Integer id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateNewsnums(Rnews record) {
        newsMapper.updateNewsnums(record);
    }
}
