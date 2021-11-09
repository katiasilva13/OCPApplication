package com.triad.ocp.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String quantity;
    private Double priceBuy;
    private Double priceSale;
    
 
}