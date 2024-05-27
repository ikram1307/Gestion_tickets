package com.Gst_tickets.Gst_tickets.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @GetMapping("/loginUser")
    public String showLoginForm() {
        return "loginUser";
    }
    @GetMapping("/login")
    public String showLoginAdmin() {
        return "login";
    }
}

