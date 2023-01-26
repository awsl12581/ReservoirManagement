package com.liguo.reservoirmanagement.controller.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nongChaTea
 * @date 2022/5/25 9:03
 */
@Controller
public class Manager {

    @GetMapping("/manager")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String manager(){
        return "manager";
    }
}
