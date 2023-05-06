package com.myclouds.manager.service.impl;

import com.myclouds.manager.mapper.RusersMapper;
import com.myclouds.manager.pojo.Rusers;
import com.myclouds.manager.pojo.RusersExample;
import com.myclouds.manager.service.RusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RusersServiceImpl implements RusersService {

    @Autowired
    private RusersMapper usersMapper;

    @Override
    public List<Rusers> findAllUsersSize() {
        return usersMapper.selectAllSize();
    }

    @Override
    public List<Rusers> getAllUsersList(Rusers bean) {
        return usersMapper.selectAll(bean);
    }

    @Override
    public List<Rusers> getUserByUid(Integer id) {
        return usersMapper.selectById(id);
    }


    @Override
    public List<Rusers> login(Rusers bean) {
        RusersExample example = new RusersExample();
        example.createCriteria().andUstuidsEqualTo(bean.getUstuids())
                .andUpwdEqualTo(bean.getUpwd());
        return usersMapper.selectByExample(example);
    }

    @Override
    public List<Rusers> findUserByUstuids(String bean) {
        return usersMapper.selectByUstuids(bean);
    }

    @Override
    public List<Rusers> selectAllSizeByFlag(Rusers bean) {
        return usersMapper.selectAllSizeByFlag(bean);
    }

    @Override
    public List<Rusers> selectAllSizeByFlagSize(Integer uid) {
        return usersMapper.selectAllSizeByFlagSize(uid);
    }

    @Override
    public List<Rusers> selectAllByBidAndFlag(Rusers bean) {
        return usersMapper.selectAllByBidAndFlag(bean);
    }

    @Override
    public List<Rusers> selectAllByBidAndFlagSize(Rusers bean) {
        return usersMapper.selectAllByBidAndFlagSize(bean);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryFlag(Rusers bean) {
        return usersMapper.selectAllByFuzzyqueryFlag(bean);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryFlagSize(Rusers bean) {
        return usersMapper.selectAllByFuzzyqueryFlagSize(bean);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryByBidFlag(Rusers bean) {
        return usersMapper.selectAllByFuzzyqueryByBidFlag(bean);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryByBidFlagSize(Rusers bean) {
        return usersMapper.selectAllByFuzzyqueryByBidFlagSize(bean);
    }


    @Override
    public List<Rusers> checkUsers(Rusers bean) {
        return usersMapper.checkUsers(bean);
    }

    @Override
    public List<Rusers> findUserByFuzzyquerySize(Rusers bean) {
        return usersMapper.selectAllByFuzzyquerySize(bean);
    }

    @Override
    public List<Rusers> findUserByFuzzyquery(Rusers bean) {
        return usersMapper.selectAllByFuzzyquery(bean);
    }

    @Override
    public void deleteUserById(Integer uid) {
        usersMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void updateUserInfo(Rusers bean) {
        usersMapper.updateUserInfo(bean);
    }

    @Override
    public void updateUserFlagInfo(Rusers bean) {
        usersMapper.updateUserFlagInfo(bean);
    }

    @Override
    public void insert(Rusers bean) {
        usersMapper.insertUserInfo(bean);
    }

    @Override
    public List<Rusers> selectAllByBidSize(Rusers record) {
        return usersMapper.selectAllByBidSize(record);
    }

    @Override
    public List<Rusers> selectAllByBid(Rusers record) {
        return usersMapper.selectAllByBid(record);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryByBidSize(Rusers record) {
        return usersMapper.selectAllByFuzzyqueryByBidSize(record);
    }

    @Override
    public List<Rusers> selectAllByFuzzyqueryByBid(Rusers record) {
        return usersMapper.selectAllByFuzzyqueryByBid(record);
    }
}
