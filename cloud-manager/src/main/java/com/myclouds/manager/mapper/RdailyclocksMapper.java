package com.myclouds.manager.mapper;

import com.myclouds.manager.pojo.Rdailyclocks;
import com.myclouds.manager.pojo.RdailyclocksExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RdailyclocksMapper {
    int countByExample(RdailyclocksExample example);

    int deleteByExample(RdailyclocksExample example);

    int deleteByPrimaryKey(Integer pid);

    List<Rdailyclocks> selectDatasForEcharts(Rdailyclocks record);
    List<Rdailyclocks> selectTeacherDatasForEcharts(Rdailyclocks record);
    List<Rdailyclocks> selectAllSize();
    List<Rdailyclocks> selectAll(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyquerySize(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyquery(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyqueryByUidSize(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyqueryByUid(Rdailyclocks record);
    List<Rdailyclocks> selectByUidSize(Integer id);
    List<Rdailyclocks> selectByUid(Rdailyclocks record);
    List<Rdailyclocks> selectById(Integer pid);
    List<Rdailyclocks> selectByBidSize(Integer id);
    List<Rdailyclocks> selectByBid(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyqueryByBidSize(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyqueryByBid(Rdailyclocks record);

    int insert(Rdailyclocks record);

    int insertSelective(Rdailyclocks record);

    List<Rdailyclocks> selectByExample(RdailyclocksExample example);

    Rdailyclocks selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Rdailyclocks record, @Param("example") RdailyclocksExample example);

    int updateByExample(@Param("record") Rdailyclocks record, @Param("example") RdailyclocksExample example);

    int updateByPrimaryKeySelective(Rdailyclocks record);

    int updateByPrimaryKey(Rdailyclocks record);
}