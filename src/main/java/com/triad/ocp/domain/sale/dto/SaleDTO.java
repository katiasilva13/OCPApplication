package com.triad.ocp.domain.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class SaleDTO {
    private Integer id;
    private Double discount;
    private Double subtotal;
    private Double total;
    private LocalDateTime moment;
    private Integer employeeId;
    private Integer clientId;
    private String saleStatus;
    private List<SaleItemDTO> saleItems;
}
