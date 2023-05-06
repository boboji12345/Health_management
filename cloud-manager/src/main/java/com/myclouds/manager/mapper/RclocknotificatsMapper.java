package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rclocknotificats;
import com.myclouds.manager.pojo.RclocknotificatsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RclocknotificatsMapper {
    int countByExample(RclocknotificatsExample example);

    int deleteByExample(RclocknotificatsExample example);

    int deleteByPrimaryKey(Integer nid);

    List<Rclocknotificats> selectAllSize();
    List<Rclocknotificats> selectById(Integer nid);
    List<Rclocknotificats> finddatasbycurrdates(String currdate);
    List<Rclocknotificats> selectAll(Rclocknotificats record);
    List<Rclocknotificats> checkdatas(Rclocknotificats record);
    List<Rclocknotificats> selectAllFuzzyquery(Rclocknotificats record);
    List<Rclocknotificats> selectAllFuzzyquerySize(Rclocknotificats record);
    List<Rclocknotificats> selectByDate(String bean);

    int insert(Rclocknotificats record);

    int insertSelective(Rclocknotificats record);

    List<Rclocknotificats> selectByExample(RclocknotificatsExample example);

    Rclocknotificats selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") Rclocknotificats record, @Param("example") RclocknotificatsExample example);

    int updateByExample(@Param("record") Rclocknotificats record, @Param("example") RclocknotificatsExample example);

    int updateByPrimaryKeySelective(Rclocknotificats record);

    int updateByPrimaryKey(Rclocknotificats record);
}