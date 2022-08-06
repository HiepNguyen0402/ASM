package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;

@Controller
public class AdminController {
	@Autowired
	AccountDAO dao;
	
    @GetMapping("/admin/account")
    	public String getAll(Model model){
//    		List<Account> accounts = dao.findAll();
//    		model.addAttribute("accounts",accounts);
    		 return "admin/account";
    }

    @GetMapping("/admin/product")
    public String product(Model model){
        return "admin/product";
    }
}
