package com.liguo.reservoirmanagement.mapper;

import com.liguo.reservoirmanagement.pojo.ReservoirInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface ReservoirInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReservoirInfo record);

    int insertSelective(ReservoirInfo record);

    ReservoirInfo selectByPrimaryKey(Integer id);

    ReservoirInfo selectByReservoirName(String name);

    int updateByPrimaryKeySelective(ReservoirInfo record);

    int updateByPrimaryKey(ReservoirInfo record);

    ArrayList<ReservoirInfo> selectByPageNumber();

    int selectNumber();

}