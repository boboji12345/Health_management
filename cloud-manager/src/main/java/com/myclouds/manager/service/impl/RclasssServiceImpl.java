package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RclasssMapper;
import com.myclouds.manager.mapper.RtypesMapper;
import com.myclouds.manager.pojo.Rclasss;
import com.myclouds.manager.pojo.RclasssExample;
import com.myclouds.manager.pojo.Rtypes;
import com.myclouds.manager.pojo.RtypesExample;
import com.myclouds.manager.service.RclasssService;
import com.myclouds.manager.service.RtypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RclasssServiceImpl implements RclasssService {

    @Autowired
    private RclasssMapper rclasssMapper;

    @Override
    public List<Rclasss> findAllRclasss() {
        RclasssExample example = new RclasssExample();
        return rclasssMapper.selectByExample(example);
    }

    @Override
    public List<Rclasss> findAllRclassById(Integer id) {
        RclasssExample example = new RclasssExample();
        example.createCriteria().andBidEqualTo(id);
        return rclasssMapper.selectByExample(example);
    }

    @Override
    public List<Rclasss> findAllRclassByName(String name) {
        RclasssExample example = new RclasssExample();
        example.createCriteria().andBnameEqualTo(name);
        return rclasssMapper.selectByExample(example);
    }
}
