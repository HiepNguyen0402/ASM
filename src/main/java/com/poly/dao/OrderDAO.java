package com.poly.dao;

import com.poly.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderDAO extends JpaRepository<Order, Integer>{
    @Query("SELECT o FROM Order o WHERE o.account.userID=?1")
    List<Order> findByuserID(String userID);
}
