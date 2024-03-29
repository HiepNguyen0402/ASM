package com.poly.service;



import java.util.List;

import com.poly.entity.Account;
	


public interface AccountService {
    List<Account> findAll();

    Account findById(String userID);

    Account create(Account account);

    Account update(Account account);

    void delete(String userID);



    List<Account> getAdminisrtators();

}
