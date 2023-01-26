package com.liguo.reservoirmanagement.controller.common;

import com.liguo.reservoirmanagement.pojo.*;
import com.liguo.reservoirmanagement.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author nongChaTea
 * @date 2022/5/15 20:14
 */
@Slf4j
@RestController
public class UserController {


    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public AjaxResult registerUser(@RequestBody UserInfo userInfo){
        userInfo.setAuthority("user");
        boolean flag = userInfoService.insertUser(userInfo);
        if (!flag){
            return new AjaxResult("500","服务器异常");
        }
        return new AjaxResult("200","注册成功");


    }

    @GetMapping("/selectuserdata")
    public AjaxResult selectUserData(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name ){
        log.warn(id+":"+name);
        AjaxResult ajaxResult=new AjaxResult("200","数据异常");
        ArrayList<UserInfo> lists=new ArrayList<>();
        if (id!=null && !"".equals(id)){
            UserInfo info = userInfoService.selectById(id);
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
            UserInfo info = userInfoService.selectByName(name);
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


    @GetMapping("/totalusernum")
    public AjaxResult totalUserNum(){
        int number = userInfoService.findNumber();
        HashMap<String,Integer> map=new HashMap<>();
        map.put("number",number);
        map.put("pagecut",10);
        return new AjaxResult("200","查询成功",map);
    }

    @RequestMapping("/loadusermessage")
    public AjaxResult loadUserMessage(Integer pagenum) throws Exception {

        ArrayList<UserInfo> list = userInfoService.selectInfoByPagenum(pagenum);

        return new AjaxResult("200","",list);

    }

    @GetMapping("/delusermsg")
    public AjaxResult delUserMsg(Integer id){

        int i = userInfoService.delInfo(id);

        if (i<=0){
            return new AjaxResult("404","参数有误");
        }

        return new AjaxResult("200","");

    }

    @PostMapping("/addusermsg")
    public AjaxResult addUserMsg(@RequestBody UserInfo commonInfo) throws Exception {

        int i = userInfoService.addInfo(commonInfo);

        if (i<=0){
            return new AjaxResult("404","添加失败");
        }
        return new AjaxResult("200","添加成功");

    }

    @PostMapping("/updateusermsg")
    public AjaxResult updateUserMsg(@RequestBody UserInfo userInfo) throws Exception {

        int i = userInfoService.updateInfo(userInfo);
        if (i<=0){
            return new AjaxResult("404","更新失败");
        }
        return new AjaxResult("200","修改成功");

    }



}
