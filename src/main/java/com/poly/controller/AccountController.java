package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccountController {

    @RequestMapping("/auth/login/success")
    public String success(Model model){
        model.addAttribute("msg","Đăng nhập thành công!");
        return "forward:/product/list";
    }

    @RequestMapping("/auth/login/error")
    public String error(Model model){
        model.addAttribute("msg","Sai thông tin đăng nhập!");
        return "forward:/auth/login/form";
    }

    @RequestMapping("/auth/logoff/success")
    public String logoff(Model model){
        model.addAttribute("msg","Đăng xuất thành công!");
        return "forward:/auth/login/form    ";
    }

    @RequestMapping("/auth/access/denied")
    public String denied(Model model){
        model.addAttribute("msg","Bạn không có quyền truy xuất");
        return "user/index";
    }
}
