package com.poly.serviceipl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO dao;

	@Override
	public List<Account> findAll() {
		
		return dao.findAll();
	}

	public Account findById(String userID) {
		
		return 	dao.findById(userID).get();
	}

	@Override
	public Account create(Account account) {
		
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		
		return dao.save(account);
	}

	@Override
	public void delete(String userID) {
		 dao.deleteById(userID);
		
	}
	
}
