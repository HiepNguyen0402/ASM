package com.poly.controller;

import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    HttpServletRequest req;
    @Autowired
    ProductService productService;
    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid")Optional<Integer>cid, @Param("keyword") String keyword){
        if (cid.isPresent()){
            List<Product> list = productService.findByCategoryId(cid.get());
            model.addAttribute("items",list);
        }else if(keyword != null){
            List<Product> list = productService.listAll(keyword);
            model.addAttribute("items", list);
            model.addAttribute("keyword", keyword);
        } else {
            List<Product> list = productService.findAll();
            model.addAttribute("items",list);
        }

        return "user/index";
    }


    @GetMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        if(req.getRemoteUser()==null){
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

    @RequestMapping("/product/contact")
    public String contact(){
        return "user/contact";
    }


}
