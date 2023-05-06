package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rusers;
import com.myclouds.manager.pojo.RusersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RusersMapper {
    int countByExample(RusersExample example);

    int deleteByExample(RusersExample example);

    int deleteByPrimaryKey(Integer uid);

    List<Rusers> selectAllSize();
    List<Rusers> selectAll(Rusers record);
    List<Rusers> selectById(Integer uid);
    List<Rusers> selectByUstuids(String record);

    List<Rusers> selectAllSizeByFlag(Rusers bean);
    List<Rusers> selectAllSizeByFlagSize(Integer uid);
    List<Rusers> selectAllByBidAndFlag(Rusers bean);
    List<Rusers> selectAllByBidAndFlagSize(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryFlag(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryFlagSize(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryByBidFlag(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryByBidFlagSize(Rusers bean);



    List<Rusers> checkUsers(Rusers record);
    List<Rusers> selectAllByFuzzyquerySize(Rusers record);
    List<Rusers> selectAllByFuzzyquery(Rusers record);
    void insertUserInfo(Rusers record);
    void updateUserInfo(Rusers record);
    void updateUserFlagInfo(Rusers record);

    List<Rusers> selectAllByBidSize(Rusers record);
    List<Rusers> selectAllByBid(Rusers record);
    List<Rusers> selectAllByFuzzyqueryByBidSize(Rusers record);
    List<Rusers> selectAllByFuzzyqueryByBid(Rusers record);

    int insert(Rusers record);

    int insertSelective(Rusers record);

    List<Rusers> selectByExample(RusersExample example);

    Rusers selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Rusers record, @Param("example") RusersExample example);

    int updateByExample(@Param("record") Rusers record, @Param("example") RusersExample example);

    int updateByPrimaryKeySelective(Rusers record);

    int updateByPrimaryKey(Rusers record);
}