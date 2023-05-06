package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Radmins;

import java.util.List;

public interface AdminService {
    List<Radmins> getAllAdminsList();
    List<Radmins> getAdminByAid(Integer aid);
    public List<Radmins> login(Radmins st);
    public List<Radmins> findAdminByAtel(String tel);
    void updateAdminInfo(Radmins admin);
}
