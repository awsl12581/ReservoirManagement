package com.liguo.reservoirmanagement.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nongChaTea
 * @date 2022/5/14 22:26
 */
@Controller
@RequestMapping("/")
public class Index {

    @RequestMapping("")
    public String index(){
        return "register";
    }
}
