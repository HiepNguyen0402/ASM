package com.poly.dao;

import com.poly.entity.Account;
import com.poly.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authorities, Integer> {
    @Query("SELECT DISTINCT a FROM Authorities a WHERE a.account IN ?1")
    List<Authorities> authoritiesOf(List<Account> accounts);
}
