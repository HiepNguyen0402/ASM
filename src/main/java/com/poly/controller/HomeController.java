package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("trangchu")
    public String index(Model model){
        return "user/index";
    }

    @GetMapping("/iphone")
    public String iphone(Model model){
        return "user/iphone";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        return "user/contact";
    }

    @GetMapping("/ipad")
    public String ipad(Model model){
        return "user/ipad";
    }

}
