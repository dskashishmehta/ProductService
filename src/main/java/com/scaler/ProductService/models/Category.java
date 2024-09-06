package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
//    @Id
//    private long id;
//    @OneToMany(cascade = CascadeType.REMOVE)  //Here we can't use this bcoz we already specified the relation between Product and Category in the Product Model
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.REMOVE)     //So we can use this means that we have already defined the Product and Category relationship in the Product table by name of category.
    private List<Product> products;     //For Lists By default fetch type is lazy which means if we call category then it will not take Product List.
    private String title;
}