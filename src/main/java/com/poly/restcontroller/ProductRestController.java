package com.poly.restcontroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.entity.Product;
import com.poly.service.ProductService;

import java.io.File;
import java.util.List;

import com.poly.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/rest/products")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/rest/products/{id}")
    public Product getOne(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @PostMapping("/rest/products")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/rest/products/{id}")
    public Product update(@PathVariable("id") Integer id,@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/rest/products/{id}")
    public void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }

    @Autowired
    UploadService uploadService;

    @PostMapping("/rest/upload/{folder}")
    public JsonNode upload(@PathParam("file") MultipartFile file,
                           @PathVariable("folder")String folder){
        File savedFile = uploadService.save(file,folder);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name",savedFile.getName());
        node.put("size",savedFile.length());
        return node;
    }

}
