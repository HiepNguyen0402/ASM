package com.poly.controller;

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
}
