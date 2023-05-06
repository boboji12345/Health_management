package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rknowledges;
import com.myclouds.manager.pojo.RknowledgesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RknowledgesMapper {
    int countByExample(RknowledgesExample example);

    int deleteByExample(RknowledgesExample example);

    int deleteByPrimaryKey(Integer rkid);

    List<Rknowledges> findAllKnowledgesSize();
    List<Rknowledges> findAllKnowledges(Rknowledges record);
    List<Rknowledges> findKnowledgesByKid(Integer rkid);
    List<Rknowledges> findAllKnowledgesByFuzzyquerySize(Rknowledges record);
    List<Rknowledges> findAllKnowledgesByFuzzyquery(Rknowledges record);


    int insert(Rknowledges record);

    int insertSelective(Rknowledges record);

    List<Rknowledges> selectByExampleWithBLOBs(RknowledgesExample example);

    List<Rknowledges> selectByExample(RknowledgesExample example);

    Rknowledges selectByPrimaryKey(Integer rkid);

    int updateByExampleSelective(@Param("record") Rknowledges record, @Param("example") RknowledgesExample example);

    int updateByExampleWithBLOBs(@Param("record") Rknowledges record, @Param("example") RknowledgesExample example);

    int updateByExample(@Param("record") Rknowledges record, @Param("example") RknowledgesExample example);

    int updateByPrimaryKeySelective(Rknowledges record);

    int updateByPrimaryKeyWithBLOBs(Rknowledges record);

    int updateByPrimaryKey(Rknowledges record);
}