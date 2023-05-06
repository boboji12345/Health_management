package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RadminsMapper;
import com.myclouds.manager.pojo.Radmins;
import com.myclouds.manager.pojo.RadminsExample;
import com.myclouds.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RadminsMapper adminMapper;

    @Override
    public List<Radmins> getAllAdminsList() {
        RadminsExample example = new RadminsExample();
        return adminMapper.selectByExample(example);
    }

    @Override
    public List<Radmins> getAdminByAid(Integer id) {
        RadminsExample example = new RadminsExample();
        example.createCriteria().andRidEqualTo(id);
        return adminMapper.selectByExample(example);
    }

    @Override
    public List<Radmins> login(Radmins admin) {
        RadminsExample example = new RadminsExample();
        example.createCriteria().andRtelEqualTo(admin.getRtel())
                .andRpwdEqualTo(admin.getRpwd());
        return adminMapper.selectByExample(example);
    }

    @Override
    public List<Radmins> findAdminByAtel(String tel) {
        RadminsExample example = new RadminsExample();
        example.createCriteria().andRtelEqualTo(tel);
        return adminMapper.selectByExample(example);
    }

    @Override
    public void updateAdminInfo(Radmins admin) {
        adminMapper.updateByPrimaryKey(admin);
    }
}
