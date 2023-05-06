package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rholidays;
import com.myclouds.manager.pojo.RholidaysExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RholidaysMapper {
    int countByExample(RholidaysExample example);

    int deleteByExample(RholidaysExample example);

    List<Rholidays> checkholidays(Rholidays record);
    List<Rholidays> selectAllSize();
    List<Rholidays> selectAll(Rholidays record);
    List<Rholidays> selectById(Integer hid);
    List<Rholidays> selectByFlag(Integer hid);
    List<Rholidays> selectAllByUidSize(Rholidays record);
    List<Rholidays> selectAllByUidAndFlag(Rholidays record);
    List<Rholidays> selectAllByUid(Rholidays record);
    List<Rholidays> selectAllByTidSize(Rholidays record);
    List<Rholidays> selectAllByTidAndFlag(Rholidays record);
    List<Rholidays> selectAllByTid(Rholidays record);
    List<Rholidays> selectAllByFuzzyquerySize(Rholidays record);
    List<Rholidays> selectAllByFuzzyquery(Rholidays record);
    List<Rholidays> selectAllByFuzzyqueryByUidSize(Rholidays record);
    List<Rholidays> selectAllByFuzzyqueryByUid(Rholidays record);
    List<Rholidays> selectAllByFuzzyqueryByTidSize(Rholidays record);
    List<Rholidays> selectAllByFuzzyqueryByTid(Rholidays record);


    int deleteByPrimaryKey(Integer hid);

    int insert(Rholidays record);

    int insertSelective(Rholidays record);

    List<Rholidays> selectByExample(RholidaysExample example);

    Rholidays selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Rholidays record, @Param("example") RholidaysExample example);

    int updateByExample(@Param("record") Rholidays record, @Param("example") RholidaysExample example);

    int updateByPrimaryKeySelective(Rholidays record);

    int updateByPrimaryKey(Rholidays record);
}