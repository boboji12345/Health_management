package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rteachers;
import com.myclouds.manager.pojo.RteachersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RteachersMapper {
    int countByExample(RteachersExample example);

    int deleteByExample(RteachersExample example);

    int deleteByPrimaryKey(Integer tuid);

    List<Rteachers> selectAllSize();
    List<Rteachers> selectAll(Rteachers record);
    List<Rteachers> selectById(Integer tuid);
    List<Rteachers> selectByTuids(String record);
    List<Rteachers> selectAllByFuzzyquerySize(Rteachers record);
    List<Rteachers> selectAllByFuzzyquery(Rteachers record);


    int insert(Rteachers record);

    int insertSelective(Rteachers record);

    List<Rteachers> selectByExample(RteachersExample example);

    Rteachers selectByPrimaryKey(Integer tuid);

    int updateByExampleSelective(@Param("record") Rteachers record, @Param("example") RteachersExample example);

    int updateByExample(@Param("record") Rteachers record, @Param("example") RteachersExample example);

    int updateByPrimaryKeySelective(Rteachers record);

    int updateByPrimaryKey(Rteachers record);
}