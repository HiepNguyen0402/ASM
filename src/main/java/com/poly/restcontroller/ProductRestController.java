package com.poly.restcontroller;

import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/rest/product/{id}")
    public Product getOne(@PathVariable("id") Integer id){
        return productService.findById(id);
    }


}
