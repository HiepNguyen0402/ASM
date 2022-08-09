package com.poly.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;

@Controller
public class AccountController {
//	@Autowired
//	AccountDAO dao;
//	
//	@GetMapping("/user/account")
//	public String getAll(Model model){
//		List<Account> accounts = dao.findAll();
//		model.addAttribute("accounts",accounts);
//		 return "admin/account";
//	}
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    @RequestMapping("/auth/login/form")
    public String form(){
        return "user/login";
    }

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
>>>>>>> master
}
