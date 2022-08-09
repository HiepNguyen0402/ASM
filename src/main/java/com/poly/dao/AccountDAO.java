package com.poly.dao;

import com.poly.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountDAO extends JpaRepository<Account, String>{
	// Derived Query - for checking if account exist by id
    public boolean existsAccountByUserID(String userID);
}
