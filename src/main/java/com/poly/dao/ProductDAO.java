package com.poly.dao;

import java.util.List;

import com.poly.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE p.category.cate_ID=?1")
    List<Product> findByCategoryId(Integer cid);

    @Query("SELECT p FROM Product p WHERE p.product_Name LIKE %?1%")
    List<Product> search(String keyword);
}
