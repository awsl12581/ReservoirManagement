package com.liguo.reservoirmanagement.mapper;

import com.liguo.reservoirmanagement.pojo.ReservoirInfo;
import com.liguo.reservoirmanagement.pojo.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUsername(String username);

    int selectNumber();

    ArrayList<UserInfo> selectByPageNumber();
}