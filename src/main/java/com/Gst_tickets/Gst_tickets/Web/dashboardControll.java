package com.Gst_tickets.Gst_tickets.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardControll {
    @GetMapping("/template1")
    public String home(){

        return "template1";
    }
    @GetMapping("/template")
    public String aaa(){

        return "template";
    }
    @GetMapping("/home")
    public String profile(){

        return "home";
    }
}
