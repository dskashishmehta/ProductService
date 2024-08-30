package com.scaler.ProductService.controllers;

import com.scaler.ProductService.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//adding comment for git testing
@RestController
@RequestMapping("/products")
public class ProductController {

    //localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return new Product();
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    //create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    //Partial Update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    //Delete Product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return;
    }
}
