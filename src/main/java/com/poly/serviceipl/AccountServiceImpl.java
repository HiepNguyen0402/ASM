package com.poly.serviceipl;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO dao;

    @Override
    public Account findById(String userID) {
        return dao.findById(userID).get();
    }
}
