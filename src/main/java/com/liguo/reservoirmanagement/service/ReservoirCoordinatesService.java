package com.liguo.reservoirmanagement.service;

import com.liguo.reservoirmanagement.mapper.ReservoirCoordinatesMapper;
import com.liguo.reservoirmanagement.pojo.ReservoirCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nongChaTea
 * @date 2022/5/23 19:37
 */
@Service
public class ReservoirCoordinatesService {


    @Autowired
    private ReservoirCoordinatesMapper reservoirCoordinatesMapper;

    public ReservoirCoordinates selectByReservoirId(Integer id){

        return reservoirCoordinatesMapper.selectByReservoirKey(id);
    }

    public int deleteByReservoirId(Integer id){
        return reservoirCoordinatesMapper.deleteByReservoirId(id);
    }

    public int insertInfo(ReservoirCoordinates reservoirCoordinates){
        int insert = reservoirCoordinatesMapper.insert(reservoirCoordinates);
        return insert;
    }
}
