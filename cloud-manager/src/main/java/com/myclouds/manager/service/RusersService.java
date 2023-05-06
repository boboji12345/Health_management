package com.myclouds.manager.service;

import com.myclouds.manager.pojo.Rusers;

import java.util.List;

public interface RusersService {
    List<Rusers> findAllUsersSize();
    List<Rusers> getAllUsersList(Rusers bean);
    List<Rusers> getUserByUid(Integer uid);
    List<Rusers> login(Rusers bean);
    List<Rusers> findUserByUstuids(String bean);


    List<Rusers> selectAllSizeByFlag(Rusers bean);
    List<Rusers> selectAllSizeByFlagSize(Integer uid);
    List<Rusers> selectAllByBidAndFlag(Rusers bean);
    List<Rusers> selectAllByBidAndFlagSize(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryFlag(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryFlagSize(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryByBidFlag(Rusers bean);
    List<Rusers> selectAllByFuzzyqueryByBidFlagSize(Rusers bean);


    List<Rusers> checkUsers(Rusers bean);
    List<Rusers> findUserByFuzzyquerySize(Rusers bean);
    List<Rusers> findUserByFuzzyquery(Rusers bean);
    void deleteUserById(Integer uid);
    void updateUserInfo(Rusers bean);
    void updateUserFlagInfo(Rusers bean);
    void insert(Rusers bean);
    List<Rusers> selectAllByBidSize(Rusers record);
    List<Rusers> selectAllByBid(Rusers record);
    List<Rusers> selectAllByFuzzyqueryByBidSize(Rusers record);
    List<Rusers> selectAllByFuzzyqueryByBid(Rusers record);
}
