package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rclasss;
import com.myclouds.manager.pojo.RclasssExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RclasssMapper {
    int countByExample(RclasssExample example);

    int deleteByExample(RclasssExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Rclasss record);

    int insertSelective(Rclasss record);

    List<Rclasss> selectByExample(RclasssExample example);

    Rclasss selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Rclasss record, @Param("example") RclasssExample example);

    int updateByExample(@Param("record") Rclasss record, @Param("example") RclasssExample example);

    int updateByPrimaryKeySelective(Rclasss record);

    int updateByPrimaryKey(Rclasss record);
}