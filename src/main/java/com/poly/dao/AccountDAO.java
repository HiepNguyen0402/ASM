package com.poly.dao;

import com.poly.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountDAO extends JpaRepository<Account, String>{
	// Derived Query - for checking if account exist by id
    public boolean existsAccountByUserID(String userID);

//    @Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.roleID IN ('AD')")
    @Query("SELECT Authorities.role.roleID  FROM Authorities a WHERE a.account.userID = ?1 ")
    Account findRole(String userID);

}
