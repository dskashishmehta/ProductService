package com.scaler.ProductService.projections;

public interface ProductWithIdAndTitle {         //It is a simple interface just to fetch these attributes from DataBase using the HQL Querie.
    Long getId();
    String getTitle();
}
