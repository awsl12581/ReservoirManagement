package com.liguo.reservoirmanagement.controller.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nongChaTea
 * @date 2022/10/1 16:32
 */
@Controller
public class Monitor {

    @GetMapping("/monitor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String monitor(){
        return "monitor";
    }
}
