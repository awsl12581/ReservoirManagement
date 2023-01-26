package com.liguo.reservoirmanagement.service;

import com.github.pagehelper.PageHelper;
import com.liguo.reservoirmanagement.mapper.ReservoirInfoMapper;
import com.liguo.reservoirmanagement.pojo.ReservoirInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author nongChaTea
 * @date 2022/5/15 23:23
 */
@Service
public class ReservoirInfoService {

    @Autowired
    private ReservoirInfoMapper reservoirInfoMapper;

    public ArrayList<ReservoirInfo> selectInfoByPagenum(Integer pagenum){
        PageHelper.startPage(pagenum,10);
        ArrayList<ReservoirInfo> list = reservoirInfoMapper.selectByPageNumber();
        return list;
    }

    public int updateInfo(ReservoirInfo reservoirInfo){
        int i = reservoirInfoMapper.updateByPrimaryKey(reservoirInfo);
        return i;
    }
    public int addInfo(ReservoirInfo reservoirInfo){
        int i = reservoirInfoMapper.insert(reservoirInfo);
        return i;
    }

    public int findNumber(){
        return reservoirInfoMapper.selectNumber();
    }

    public int delInfo(Integer id){
        return reservoirInfoMapper.deleteByPrimaryKey(id);
    }

    public ReservoirInfo selectById(Integer id){
        return reservoirInfoMapper.selectByPrimaryKey(id);
    }

    public ReservoirInfo selectByName(String name){
        return reservoirInfoMapper.selectByReservoirName(name);
    }

}
