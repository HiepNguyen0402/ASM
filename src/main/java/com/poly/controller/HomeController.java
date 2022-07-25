package com.poly.controller;

import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;
    @GetMapping("/product/list")
    public String index(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        return "user/index";
    }

    @GetMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Product product = productService.findById(id);
        model.addAttribute("items", product);
        return "product";
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
