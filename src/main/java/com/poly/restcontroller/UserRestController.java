package com.poly.restcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/account")
public class UserRestController {
	
	@Autowired
    AccountService accountService;
	
	@GetMapping()
	public List<Account> getAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/user/account/{userID}")
	public Account getOne(@PathVariable("userID") String userID) {
		 return  accountService.findById(userID);
		
		}
	
	@PostMapping()
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}

	
	@PutMapping("{userID}")
	public Account update(@PathVariable("userID") String userID, @RequestBody Account account) {
		return accountService.update(account);
	}
	
	@DeleteMapping("{userID}")
	public void delete(@PathVariable("userID") String userID) {
			accountService.delete(userID);
		}


	@GetMapping("/rest/accounts")
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if (admin.orElse(false)){
			return accountService.getAdminisrtators();
		}
		return accountService.findAll();
	}
}
