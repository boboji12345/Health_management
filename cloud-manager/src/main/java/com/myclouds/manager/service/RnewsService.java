package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rnews;

import java.util.List;

public interface RnewsService {
    List<Rnews> findAllNewsSize();
    List<Rnews> getAllNewsList(Rnews bean);
    List<Rnews> getAllNewsList10();
    List<Rnews> getNewsById(Integer id);
    List<Rnews> findNewsByFuzzyquerySize(Rnews bean);
    List<Rnews> findNewsByFuzzyquery(Rnews bean);
    List<Rnews> checkNews(String name);
    void updateNewsInfo(Rnews bean);
    void insertNewsInfo(Rnews bean);
    void deleteNewsById(Integer id);
    void updateNewsnums(Rnews record);
}
