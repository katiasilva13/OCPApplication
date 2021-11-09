package com.triad.ocp.domain.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaleItemDTO {
    private Integer id;
    private Double count;
    private Double value;
    private Integer saleId;
//    private Integer productId;
}
