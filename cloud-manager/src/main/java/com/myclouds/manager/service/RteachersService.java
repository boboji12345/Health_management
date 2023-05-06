package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rteachers;
import com.myclouds.manager.pojo.Rusers;

import java.util.List;

public interface RteachersService {
    List<Rteachers> findAllRteachersSize();
    List<Rteachers> getAllRteachersList(Rteachers bean);
    List<Rteachers> getRteachersByUid(Integer uid);
    List<Rteachers> getRteachersByBid(Integer uid);
    List<Rteachers> login(Rteachers bean);
    List<Rteachers> findRteachersByTuids(String bean);
    List<Rteachers> checkRteachers(Rteachers bean);
    List<Rteachers> findRteachersByFuzzyquerySize(Rteachers bean);
    List<Rteachers> findRteachersByFuzzyquery(Rteachers bean);
    void deleteRteachersById(Integer uid);
    void updateRteachersInfo(Rteachers bean);
    void insert(Rteachers bean);
}
