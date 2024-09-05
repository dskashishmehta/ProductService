package com.scaler.ProductService.services;

import com.scaler.ProductService.exceptions.InvalidProductIdException;
import com.scaler.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product) throws Exception;

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
