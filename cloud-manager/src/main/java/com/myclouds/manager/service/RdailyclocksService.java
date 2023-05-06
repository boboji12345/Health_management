package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rdailyclocks;
import com.myclouds.manager.pojo.Rnews;

import java.util.List;

public interface RdailyclocksService {
    List<Rdailyclocks> findDatasForEcharts(Rdailyclocks record);
    List<Rdailyclocks> findTeacherDatasForEcharts(Rdailyclocks record);
    List<Rdailyclocks> findAllRdailyclocksSize();
    List<Rdailyclocks> getAllRdailyclocksList(Rdailyclocks bean);
    List<Rdailyclocks> getRdailyclocksById(Integer id);
    List<Rdailyclocks> getRdailyclocksByUidSize(Integer uid);
    List<Rdailyclocks> getRdailyclocksByUid(Rdailyclocks bean);
    List<Rdailyclocks> findRdailyclocksByFuzzyquerySize(Rdailyclocks bean);
    List<Rdailyclocks> findRdailyclocksByFuzzyquery(Rdailyclocks bean);
    List<Rdailyclocks> findRdailyclocksByFuzzyqueryByUidSize(Rdailyclocks bean);
    List<Rdailyclocks> findRdailyclocksByFuzzyqueryByUid(Rdailyclocks bean);
    List<Rdailyclocks> selectAllByFuzzyqueryByBidSize(Rdailyclocks record);
    List<Rdailyclocks> selectAllByFuzzyqueryByBid(Rdailyclocks record);
    List<Rdailyclocks> checkRdailyclocks(Rdailyclocks bean);
    List<Rdailyclocks> selectByBidSize(Integer id);
    List<Rdailyclocks> selectByBid(Rdailyclocks record);
    void updateRdailyclocksInfo(Rdailyclocks bean);
    void insertRdailyclocksInfo(Rdailyclocks bean);
    void deleteRdailyclocksById(Integer id);
}
