package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rtypes;

import java.util.List;

public interface RtypesService {
    List<Rtypes> findAllTypesSize();
    List<Rtypes> getAllTypesList(Rtypes bean);
    List<Rtypes> getAllTypesList10();
    List<Rtypes> getTypesById(Integer id);
    List<Rtypes> findTypesByFuzzyquerySize(Rtypes bean);
    List<Rtypes> findTypesByFuzzyquery(Rtypes bean);
    List<Rtypes> checkTypes(Rtypes bean);
    void deleteTypeById(Integer id);
    void updateTypesInfo(Rtypes bean);
    void insertTypesInfo(Rtypes bean);
}
