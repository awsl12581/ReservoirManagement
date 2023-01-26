package com.liguo.reservoirmanagement.controller.common;

import com.liguo.reservoirmanagement.pojo.AjaxResult;
import com.liguo.reservoirmanagement.pojo.CommonInfo;
import com.liguo.reservoirmanagement.pojo.ReservoirCoordinates;
import com.liguo.reservoirmanagement.pojo.ReservoirInfo;
import com.liguo.reservoirmanagement.service.ReservoirCoordinatesService;
import com.liguo.reservoirmanagement.service.ReservoirInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author nongChaTea
 * @date 2022/5/15 23:30
 */
@RestController
@Slf4j
public class ReservoirController {

    @Autowired
    private ReservoirInfoService reservoirInfoService;

    @Autowired
    private ReservoirCoordinatesService reservoirCoordinatesService;

    @RequestMapping("/loadmessage")
    public AjaxResult loadMessage(Integer pagenum) throws Exception {

        ArrayList<ReservoirInfo> list = reservoirInfoService.selectInfoByPagenum(pagenum);

        return new AjaxResult("200","",list);

    }

    @PostMapping("/updatemsg")
    public AjaxResult updateMsg(@RequestBody ReservoirInfo reservoirInfo) throws Exception {

        int i = reservoirInfoService.updateInfo(reservoirInfo);
        if (i<=0){
            return new AjaxResult("404","更新失败");
        }
        return new AjaxResult("200","修改成功");

    }

    @PostMapping("/addmsg")
    public AjaxResult addMsg(@RequestBody CommonInfo commonInfo) throws Exception {

        ReservoirInfo reservoirInfo = commonInfo;

        int i = reservoirInfoService.addInfo(reservoirInfo);

        int reservoirId = reservoirInfo.getId();

        ReservoirCoordinates reservoirCoordinates = new ReservoirCoordinates();
        reservoirCoordinates.setReservoirId(reservoirId);;
        reservoirCoordinates.setLat(commonInfo.getLat());
        reservoirCoordinates.setLng(commonInfo.getLng());
        reservoirCoordinates.setRecord(commonInfo.getRecord());

        int j = reservoirCoordinatesService.insertInfo(reservoirCoordinates);


        if (i<=0){
            return new AjaxResult("404","添加失败");
        }
        return new AjaxResult("200","添加成功");

    }

    @GetMapping("/totalnum")
    public AjaxResult totalNum(){
        int number = reservoirInfoService.findNumber();
        HashMap<String,Integer> map=new HashMap<>();
        map.put("number",number);
        map.put("pagecut",10);
        return new AjaxResult("200","查询成功",map);
    }

    @GetMapping("/delmsg")
    public AjaxResult delMsg(Integer id){

        int i = reservoirInfoService.delInfo(id);
        int j = reservoirCoordinatesService.deleteByReservoirId(id);

        if (i<=0){
            return new AjaxResult("404","参数有误");
        }

        return new AjaxResult("200","");

    }

    @GetMapping("/selectdata")
    public AjaxResult selectData(@RequestParam(required = false) Integer id,@RequestParam(required = false) String name ){
        log.warn(id+":"+name);
        AjaxResult ajaxResult=new AjaxResult("200","数据异常");
        ArrayList<ReservoirInfo> lists=new ArrayList<>();
        if (id!=null && !"".equals(id)){
            ReservoirInfo info = reservoirInfoService.selectById(id);
            if (info!=null && info.getId()!=0){
                lists.add(info);
                ajaxResult =new AjaxResult("200","",lists);
                log.debug(ajaxResult.toString());
            }else {
                return new AjaxResult("404","未找到相应数据");
            }
            return ajaxResult;
        }
        if (name!=null && !"".equals(name)){
            ReservoirInfo info = reservoirInfoService.selectByName(name);
            lists.add(info);
            if (info!=null && info.getId()!=0){
                ajaxResult =new AjaxResult("200","",lists);
                log.debug(ajaxResult.toString());
            }else {
                return new AjaxResult("404","未找到相应数据");
            }
            return ajaxResult;
        }
        return ajaxResult;
    }

}
