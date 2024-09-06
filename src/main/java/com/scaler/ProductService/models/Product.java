package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private long id;            --> Common attributes of entities moved to the baseModel class.
    private String title;
    private double price;
//    @ManyToOne(cascade = CascadeType.ALL)    //CascadeType All meaning if we take any operation like Delete, update etc. on Product it should also be done in the Category table.
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)  // It only involves save functionality like if we save in product then also save in category.
    private Category category;        //Fetch_type lazy meaning if we don't want to fetch category, by default for single item it is eager.
//    @ManyToMany
//    private List<Category> category;
    private String description;
    private String image;
}
