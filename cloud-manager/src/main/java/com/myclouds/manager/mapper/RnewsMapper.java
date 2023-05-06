package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rnews;
import com.myclouds.manager.pojo.RnewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RnewsMapper {
    int countByExample(RnewsExample example);

    int deleteByExample(RnewsExample example);

    int deleteByPrimaryKey(Integer rnid);

    List<Rnews> findNewsByNid(Integer rnid);
    List<Rnews> findAllNewsSize();
    List<Rnews> findAllNews(Rnews record);
    List<Rnews> findAllNewsByFuzzyquerySize(Rnews record);
    List<Rnews> findAllNewsByFuzzyquery(Rnews record);
    void updateNewsnums(Rnews record);

    int insert(Rnews record);

    int insertSelective(Rnews record);

    List<Rnews> selectByExampleWithBLOBs(RnewsExample example);

    List<Rnews> selectByExample(RnewsExample example);

    Rnews selectByPrimaryKey(Integer rnid);

    int updateByExampleSelective(@Param("record") Rnews record, @Param("example") RnewsExample example);

    int updateByExampleWithBLOBs(@Param("record") Rnews record, @Param("example") RnewsExample example);

    int updateByExample(@Param("record") Rnews record, @Param("example") RnewsExample example);

    int updateByPrimaryKeySelective(Rnews record);

    int updateByPrimaryKeyWithBLOBs(Rnews record);

    int updateByPrimaryKey(Rnews record);
}