package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.exceptions.InvalidProductIdException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class FakeStoreProductServiceImpl implements ProductService {


    private RestTemplate restTemplate;

    FakeStoreProductServiceImpl(RestTemplate restTemplate){
        this .restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Call the FakeStore API to get the product with given ID here.
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if(fakeStoreProductDto==null){
            throw new InvalidProductIdException(id, "Product Id not valid");     //Custom Exception created.
        }
//      Convert fakeStoreProductDto to product Object.
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

//        throw new RuntimeException("Something went wrong");
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto  fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id,Product product) {
        //PUT Method
        //Replace the product with given id with input product
        //and Return the updated product

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
