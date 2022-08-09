package com.poly.controller;

import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("msg","Vui lòng đăng nhập!");
        return "security/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        String role = String.valueOf((accountService.findRole(username)));
        model.addAttribute("msg","Đăng nhập thành công"+role);
        return "security/login";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("msg","Sai thông tin đăng nhập");
        return "security/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("msg","Không có quyền truy xuất");
        return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model){
        model.addAttribute("msg","Bạn đã đăng xuất!");
        return "security/login";
    }
}
