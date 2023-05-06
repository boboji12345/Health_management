package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rclocknotificats;
import com.myclouds.manager.pojo.Rdailyclocks;

import java.util.List;

public interface RclocknotificatsService {
    List<Rclocknotificats> selectAllSize();
    List<Rclocknotificats> selectAll(Rclocknotificats record);
    List<Rclocknotificats> selectById(Integer nid);
    List<Rclocknotificats> finddatasbycurrdates(String currdate);
    List<Rclocknotificats> checkdatas(Rclocknotificats record);
    List<Rclocknotificats> selectAllFuzzyquery(Rclocknotificats record);
    List<Rclocknotificats> selectAllFuzzyquerySize(Rclocknotificats record);
    List<Rclocknotificats> selectByDate(String bean);
    void updateRclocknotificatsInfo(Rclocknotificats bean);
    void insertRclocknotificatsInfo(Rclocknotificats bean);
    void deleteRclocknotificatsById(Integer id);
}
