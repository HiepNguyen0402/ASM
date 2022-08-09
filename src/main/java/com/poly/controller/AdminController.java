package com.poly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Product;
import com.poly.service.ProductService;

import java.util.List;
import java.util.Optional;

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
