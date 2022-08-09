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
public class AdminController {
	@Autowired
	AccountDAO dao;
	
    @GetMapping("/admin/account")
    	public String getAll(Model model){
//    		List<Account> accounts = dao.findAll();
//    		model.addAttribute("accounts",accounts);
    		 return "admin/account";
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
>>>>>>> master
    }

    @GetMapping("/admin/product")
    public String checkproductLog(){
        return "admin/product";
    }

//    @PreAuthorize("hasRole('0')")
//    @GetMapping("/admin/account")
//    public String account(){
//        return "admin/account";
//    }



//    @PreAuthorize("hasRole('0')")
//    @GetMapping("/admin/product")
//    public String product(Model model){
//        return "admin/product";
//    }
}
