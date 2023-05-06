package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RtypesMapper;
import com.myclouds.manager.pojo.Rtypes;
import com.myclouds.manager.pojo.RtypesExample;
import com.myclouds.manager.service.RtypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RtypesServiceImpl implements RtypesService {

    @Autowired
    private RtypesMapper rtypesMapper;

    @Override
    public List<Rtypes> findAllTypesSize() {
        return rtypesMapper.selectAllSize();
    }

    @Override
    public List<Rtypes> getAllTypesList(Rtypes bean) {
        return rtypesMapper.selectAll(bean);
    }

    @Override
    public List<Rtypes> getAllTypesList10() {
        RtypesExample example = new RtypesExample();
        example.setOrderByClause(" rtid desc");
        List<Rtypes> types = rtypesMapper.selectByExample(example)
                .stream().limit(10).collect(Collectors.toList());
        return types;
    }

    @Override
    public List<Rtypes> getTypesById(Integer id) {
        RtypesExample example = new RtypesExample();
        example.createCriteria().andRtidEqualTo(id);
        return rtypesMapper.selectByExample(example);
    }

    @Override
    public List<Rtypes> findTypesByFuzzyquerySize(Rtypes bean) {
        return rtypesMapper.selectAllByFuzzyquerySize(bean);
    }

    @Override
    public List<Rtypes> findTypesByFuzzyquery(Rtypes bean) {
        return rtypesMapper.selectAllByFuzzyquery(bean);
    }

    @Override
    public List<Rtypes> checkTypes(Rtypes bean) {
        RtypesExample example = new RtypesExample();
        example.createCriteria().andRtnameEqualTo(bean.getRtname());
        return rtypesMapper.selectByExample(example);
    }

    @Override
    public void updateTypesInfo(Rtypes bean) {
        rtypesMapper.updateByPrimaryKey(bean);
    }

    @Override
    public void insertTypesInfo(Rtypes bean) {
        rtypesMapper.insert(bean);
    }

    @Override
    public void deleteTypeById(Integer tid) {
        rtypesMapper.deleteByPrimaryKey(tid);
    }
}
