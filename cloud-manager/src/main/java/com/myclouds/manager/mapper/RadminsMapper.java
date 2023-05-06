package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Radmins;
import com.myclouds.manager.pojo.RadminsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RadminsMapper {
    int countByExample(RadminsExample example);

    int deleteByExample(RadminsExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Radmins record);

    int insertSelective(Radmins record);

    List<Radmins> selectByExample(RadminsExample example);

    Radmins selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Radmins record, @Param("example") RadminsExample example);

    int updateByExample(@Param("record") Radmins record, @Param("example") RadminsExample example);

    int updateByPrimaryKeySelective(Radmins record);

    int updateByPrimaryKey(Radmins record);
}