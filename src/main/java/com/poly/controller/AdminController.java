package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/account")
    public String account(Model model){
        return "admin/account";
    }

    @GetMapping("/admin/product")
    public String product(Model model){
        return "admin/product";
    }
}
