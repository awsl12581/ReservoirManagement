package com.liguo.reservoirmanagement.controller.api;

import com.liguo.reservoirmanagement.pojo.ReservoirCoordinates;
import com.liguo.reservoirmanagement.service.ReservoirCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nongChaTea
 * @date 2022/5/15 21:57
 */
@Controller
public class Home {

    @Autowired
    private ReservoirCoordinatesService reservoirCoordinatesService;

    @RequestMapping("/home")
    public String index(){
        return "home";
    }

    @RequestMapping("/acquire")
    public ModelAndView qcquire(Integer id){

        ReservoirCoordinates reservoirCoordinates;
        reservoirCoordinates = reservoirCoordinatesService.selectByReservoirId(id);
        ModelAndView modelAndView  = new ModelAndView("chart");
        modelAndView.getModel().put("data",reservoirCoordinates);

        return modelAndView;
    }
}