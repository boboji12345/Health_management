package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rinoutsigns;
import com.myclouds.manager.pojo.Rinoutsigns;

import java.util.List;

public interface RinoutsignsService {
    List<Rinoutsigns> findAllRinoutsignsSize();
    List<Rinoutsigns> getAllRinoutsignsList(Rinoutsigns bean);
    List<Rinoutsigns> getRinoutsignsById(Integer id);
    List<Rinoutsigns> getRinoutsignsByUidSize(Integer uid);
    List<Rinoutsigns> getRinoutsignsByUid(Rinoutsigns bean);
    List<Rinoutsigns> selectByBidSize(Integer id);
    List<Rinoutsigns> selectByBid(Rinoutsigns record);
    List<Rinoutsigns> findRinoutsignsByFuzzyquerySize(Rinoutsigns bean);
    List<Rinoutsigns> findRinoutsignsByFuzzyquery(Rinoutsigns bean);
    List<Rinoutsigns> findRinoutsignsByFuzzyqueryByUidSize(Rinoutsigns bean);
    List<Rinoutsigns> findRinoutsignsByFuzzyqueryByUid(Rinoutsigns bean);
    void updateRinoutsignsInfo(Rinoutsigns bean);
    void insertRinoutsignsInfo(Rinoutsigns bean);
    void deleteRinoutsignsById(Integer id);
    List<Rinoutsigns> selectAllByFuzzyqueryByBidSize(Rinoutsigns record);
    List<Rinoutsigns> selectAllByFuzzyqueryByBid(Rinoutsigns record);
}
