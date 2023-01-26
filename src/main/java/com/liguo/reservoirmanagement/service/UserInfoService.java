package com.liguo.reservoirmanagement.service;

import com.github.pagehelper.PageHelper;
import com.liguo.reservoirmanagement.mapper.UserInfoMapper;
import com.liguo.reservoirmanagement.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author nongChaTea
 * @date 2022/5/15 18:22
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo identifyUser(String username) {
        UserInfo userInfo = userInfoMapper.selectByUsername(username);
        System.out.println(userInfo.toString());
        return userInfo;
    }

    public Boolean insertUser(UserInfo userInfo) {
        UserInfo check = userInfoMapper.selectByUsername(userInfo.getUsername());
        if (check != null) {
            return false;
        }

        Integer id = userInfoMapper.insert(userInfo);
        if (userInfo.getId() != null) {
            return true;
        }
        return false;
    }

    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }


    public UserInfo selectByName(String name) {
        return userInfoMapper.selectByUsername(name);
    }

    public int findNumber() {
        return userInfoMapper.selectNumber();
    }

    public ArrayList<UserInfo> selectInfoByPagenum(Integer pagenum) {
        PageHelper.startPage(pagenum, 10);
        ArrayList<UserInfo> list = userInfoMapper.selectByPageNumber();
        return list;
    }

    public int delInfo(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }


    public int addInfo(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    public int updateInfo(UserInfo userInfo) {
        int i = userInfoMapper.updateByPrimaryKey(userInfo);
        return i;
    }
}
