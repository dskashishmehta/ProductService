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
    @ManyToOne
    private Category category;
//    @ManyToMany
//    private List<Category> category;
    private String description;
    private String image;
}
