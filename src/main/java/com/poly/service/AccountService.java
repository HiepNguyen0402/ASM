package com.poly.service;

<<<<<<< HEAD


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
	


public interface AccountService {
    List<Account> findAll();
    
    Account findById(String userID);
    
    Account create(Account account);
    
	Account update(Account account);

	void delete(String userID);
    
   


//    public void register(Account acc, String url) throws MessagingException {
//        //encode the password with Bcrypt algorithm
//        String encodedPassword = Bcryptor.encrypt(acc.getPassword());
//        String randomCode = RandomString.make(64);
//        acc.setPassword(encodedPassword);
//        acc.setVerifycode(randomCode);
//        acc.setActivated(false);
//        acc.setAdmin(false);
//        dao.save(acc);
//        sendVerifyEmail(acc, url);
//    }

//    public void save(Account acc) {
//        //encode the password with Bcrypt algorithm
//        String encodedPassword = Bcryptor.encrypt(acc.getPassword());
//        acc.setPassword(encodedPassword);
//        dao.save(acc);
//    }

    

   
=======
import com.poly.entity.Account;

public interface AccountService {
    Account findById(String userID);
>>>>>>> master
}
