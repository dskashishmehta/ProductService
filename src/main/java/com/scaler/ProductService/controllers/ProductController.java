package com.scaler.ProductService.controllers;

import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//adding comment for git testing
@RestController
@RequestMapping("/products")
public class ProductController {

//    ProductController is dependent on Service so, need object of service in controller;
//    Instead of creating the obj ect dependency like below we need to use constructor dependency injection for this we need to use annotation in the service class like @Service or @Component so that it will create bean.
//    ProductService productService = new ProductService();
//
    private ProductService productService;
//
//    //Before injecting the dependency we need to create a Service object using the @Service in service.
    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }



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
