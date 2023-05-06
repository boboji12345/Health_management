package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rtypes;
import com.myclouds.manager.pojo.RtypesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RtypesMapper {
    int countByExample(RtypesExample example);

    int deleteByExample(RtypesExample example);

    List<Rtypes> selectAllSize();
    List<Rtypes> selectAll(Rtypes record);
    List<Rtypes> selectAllByFuzzyquerySize(Rtypes record);
    List<Rtypes> selectAllByFuzzyquery(Rtypes record);

    int deleteByPrimaryKey(Integer rtid);

    int insert(Rtypes record);

    int insertSelective(Rtypes record);

    List<Rtypes> selectByExample(RtypesExample example);

    Rtypes selectByPrimaryKey(Integer rtid);

    int updateByExampleSelective(@Param("record") Rtypes record, @Param("example") RtypesExample example);

    int updateByExample(@Param("record") Rtypes record, @Param("example") RtypesExample example);

    int updateByPrimaryKeySelective(Rtypes record);

    int updateByPrimaryKey(Rtypes record);
}