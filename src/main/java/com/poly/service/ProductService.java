package com.poly.service;

import com.poly.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

//    Product findById(Integer id);


    Product findById(Integer id);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

   

	List<Product> findByCategoryId(String cid);
}
