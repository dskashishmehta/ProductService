package com.scaler.ProductService.inheritancerepresentation.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
@Entity(name = "msc_ta")
public class TA extends User{
    private int numberOfSessions;
    private double avgRating;
}
