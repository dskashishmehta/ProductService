package com.scaler.ProductService.controllers;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.scaler.ProductService.exceptions.InvalidProductIdException;
import com.scaler.ProductService.exceptions.ProductControllerSpecificExceptions;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws InvalidProductIdException {
//         throw new RuntimeException("Here the manual exce  ption created");
        Product product =  productService.getProductById(id);
//        return new ResponseEntity<>(product, HttpStatusCode.valueOf(404));
//        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);

//        Product product = null;
//        try{
//            product =  productService.getProductById(id);
//        }catch(RuntimeException e){
//            System.out.println("Something went wrong");
//            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(product, HttpStatus.OK);

//        int a = 1/0;
//        return null;
    }

    //localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
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
        return productService.replaceProduct(id,product);
    }

    //Delete Product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return;
    }

    ////Below one exception is an example of controller specific exceptions.
    @ExceptionHandler(ProductControllerSpecificExceptions.class)
    public ResponseEntity<Void> handleProductControllerSpecificExceptions(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
