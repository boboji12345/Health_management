package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rdailyclocks;
import com.myclouds.manager.pojo.Rholidays;

import java.util.List;

public interface RholidaysService {
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
    void updateRholidaysInfo(Rholidays bean);
    void insertRholidaysInfo(Rholidays bean);
    void deleteRholidaysById(Integer id);
}
