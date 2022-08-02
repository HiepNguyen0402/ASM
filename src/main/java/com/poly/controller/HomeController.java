package com.poly.controller;

import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HttpServletRequest req;
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
        if(!req.isUserInRole("0")){
            return "redirect:/auth/access/denied";
        }
        Product product = productService.findById(id);
        model.addAttribute("items", product);
        return "product";
    }

    @RequestMapping("/product/authenticated")
    public String authenticated(){
        if(req.getRemoteUser()==null) {
            return "redirect:/auth/login";
        }
        return "product/list";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        return "user/contact";
    }


}
