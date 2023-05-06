package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rinoutsigns;
import com.myclouds.manager.pojo.RinoutsignsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RinoutsignsMapper {
    int countByExample(RinoutsignsExample example);

    int deleteByExample(RinoutsignsExample example);

    int deleteByPrimaryKey(Integer cid);

    List<Rinoutsigns> selectAllSize();
    List<Rinoutsigns> selectAll(Rinoutsigns record);
    List<Rinoutsigns> selectByUidSize(Integer id);
    List<Rinoutsigns> selectByUid(Rinoutsigns record);
    List<Rinoutsigns> selectByBidSize(Integer id);
    List<Rinoutsigns> selectByBid(Rinoutsigns record);
    List<Rinoutsigns> selectById(Integer id);
    List<Rinoutsigns> selectAllByFuzzyquerySize(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyquery(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyqueryByUidSize(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyqueryByUid(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyqueryByBidSize(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyqueryByBid(Rinoutsigns record);

    int insert(Rinoutsigns record);

    int insertSelective(Rinoutsigns record);

    List<Rinoutsigns> selectByExample(RinoutsignsExample example);

    Rinoutsigns selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Rinoutsigns record, @Param("example") RinoutsignsExample example);

    int updateByExample(@Param("record") Rinoutsigns record, @Param("example") RinoutsignsExample example);

    int updateByPrimaryKeySelective(Rinoutsigns record);

    int updateByPrimaryKey(Rinoutsigns record);
}