package com.liguo.reservoirmanagement.mapper;

import com.liguo.reservoirmanagement.pojo.ReservoirCoordinates;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReservoirCoordinatesMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByReservoirId(Integer id);

    ReservoirCoordinates selectByReservoirKey(Integer id);

    int insert(ReservoirCoordinates record);

    int insertSelective(ReservoirCoordinates record);

    ReservoirCoordinates selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReservoirCoordinates record);

    int updateByPrimaryKey(ReservoirCoordinates record);
}