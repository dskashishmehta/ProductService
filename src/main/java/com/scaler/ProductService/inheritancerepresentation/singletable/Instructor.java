package com.scaler.ProductService.inheritancerepresentation.singletable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Instructor extends User {
    private String specialisation;
}
