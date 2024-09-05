package com.scaler.ProductService.services;

import com.scaler.ProductService.exceptions.InvalidProductIdException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.CategoryRepository;
import com.scaler.ProductService.repositories.ProductRepository;
import com.scaler.ProductService.services.ProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Fetch Product with given ID from DB.

        Optional<Product> optionalProduct = productRepository.findById(id);;

        if(optionalProduct.isEmpty()){
            //throw an Exception --> ProductNotFound
        }

        Product product = optionalProduct.get();
//        Category category = product.getCategory();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            //first insert the category in the DB.
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws Exception {

        if(product == null) throw new RuntimeException("Invalid input exception to update method");   //Data getting from Postman User for update.

        Optional<Product> optionalProduct = productRepository.findById(id);  //Data getting from DataBase.

        if(optionalProduct.isEmpty()) throw new RuntimeException("No values available in database");       //If dataBase data is empty then throw an error.

        Product currentProduct = optionalProduct.get();   //current existing data in database.
//******************************************************************************************************
        if(product.getTitle() != null){
            currentProduct.setTitle(product.getTitle());    //set the new data 1-by-1 to the current data.
        }
        if(product.getDescription() != null){
            currentProduct.setDescription(product.getDescription());  //@Question: If we have more than 50 columns to set values then how to do it?
        }


//*******************************************************************************************************
//        //Not working this logic now need to check it.
//        //To deal with the question above we can use dependency Apache commons BeanUtils.
//        //This would dynamically copy non-null properties, from the incoming object to the existing one.
//        // Make sure Category is managed/persisted before setting it
//        if (product.getCategory() != null) {
//            Category category = product.getCategory();
//            if (category.getId() == null) {
//                // Save the Category first if it's new (not persisted yet)
//                categoryRepository.save(category);
//            }
//            currentProduct.setCategory(category);
//        }
//
//        BeanUtils.copyProperties(currentProduct, product);
//********************************************************************************************************
        return productRepository.save(currentProduct);      //Save it to the DB.
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
