package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rknowledges;
import com.myclouds.manager.pojo.Rnews;

import java.util.List;

public interface RknowledgesService {
    List<Rknowledges> findAllKnowledgesSize();
    List<Rknowledges> getAllKnowledgesList(Rknowledges bean);
    List<Rknowledges> getKnowledgesById(Integer id);
    List<Rknowledges> findKnowledgesByFuzzyquerySize(Rknowledges bean);
    List<Rknowledges> findKnowledgesByFuzzyquery(Rknowledges bean);
    List<Rknowledges> checkKnowledges(String name);
    void updateKnowledgesInfo(Rknowledges bean);
    void insertKnowledgesInfo(Rknowledges bean);
    void deleteKnowledgesById(Integer id);
}
