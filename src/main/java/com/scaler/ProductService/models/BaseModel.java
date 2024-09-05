package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass        //-->>It will not create an object of the class as this is just common attributes. We can also make it abstract.
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
