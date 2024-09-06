package com.scaler.ProductService.repositories;

import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //<Which table need to interact with, DataType of Primary Key>


    Optional<Product> findById(Long id); //We need to return optional of product, because findById can also return null object.
    //So, to avoid null pointer exception we use Optional<Product>

    Optional<Product> findByTitleAndDescription(String title, String Description);

    List<Product> findByTitleContaining(String word);       //This is not optional bcoz, list can be empty, but can't be null.

    List<Product> findTopThreeByTitle(String title);        //limit the result by three.

    Optional<Product> findByCategory(Category category);

    void deleteById(Long id);

    void deleteByTitle(String title);

    Product save(Product product);

    //HQL Query example below:
    //**HQL is Hibernate Query Language, so this uses the class_name instead of table_name, and Attributes of class instead of column names.

    @Query("select p.id as id, p.title as title from Product p where p.price > 100000 and lower(p.title) like '%pro%' ")
    List<ProductWithIdAndTitle> someRandomQuery();  //Why this ProductWithIdAndTitle because Hibernate will identify that this is not a complete product, it is just id and title.

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    ProductWithIdAndTitle doSomething(@Param("id") Long id);

    @Query(value = "select * from product where id = 2", nativeQuery = true)
    Product doSomethingSQL();
}
 /*
 Product findById(id) -->> select * from product where id = <id>;
 List<Product> findAll()     -->> select * from product;
  */