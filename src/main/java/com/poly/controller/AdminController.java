package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("/admin/account")
    public String checkAccoutnLog(){
        if(!req.isUserInRole("AD")){
            return "redirect:/auth/access/denied";
        }
        return "admin/account";
    }

    @GetMapping("/admin/product")
    public String checkproductLog(){
        return "admin/product";
    }
}
