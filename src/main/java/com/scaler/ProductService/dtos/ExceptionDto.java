package com.scaler.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private long productId;
    private String message;
}
