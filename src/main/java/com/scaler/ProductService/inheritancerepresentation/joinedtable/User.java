package com.scaler.ProductService.inheritancerepresentation.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_user")
public class User {
    @Id
    private long userId;
    private String name;
    private String email;
    private String password;
}
