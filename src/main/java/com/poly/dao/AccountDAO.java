package com.poly.dao;

import com.poly.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AccountDAO extends JpaRepository<Account, String>{
    @Query("SELECT DISTINCT ar.account FROM Authorities ar WHERE ar.role.roleID IN ('AD')")
    List<Account> getAdministrators();
}
