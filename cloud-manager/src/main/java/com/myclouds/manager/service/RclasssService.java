package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rclasss;
import com.myclouds.manager.pojo.Rtypes;

import java.util.List;

public interface RclasssService {
    List<Rclasss> findAllRclasss();
    List<Rclasss> findAllRclassById(Integer id);
    List<Rclasss> findAllRclassByName(String name);
}
