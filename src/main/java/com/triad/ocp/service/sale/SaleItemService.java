package com.triad.ocp.service.sale;

import antlr.ASTNULLType;
import com.triad.ocp.domain.product.Product;
import com.triad.ocp.domain.sale.Sale;
import com.triad.ocp.domain.sale.SaleItem;
import com.triad.ocp.domain.sale.dto.SaleItemDTO;
import com.triad.ocp.repository.sale.SaleItemRepository;
import com.triad.ocp.service.product.ProductService;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

public class SalemItemService implements Serializable {

    public final SaleItemDTO saleItemDTO;
    public final Sale sale;
    public final ProductService productService;
    private final Product product;
    private SaleItemRepository repository;

    public SalemItemService(SaleItemDTO saleItemDTO, Sale sale, ProductService productService, Product product) {
        this.saleItemDTO = saleItemDTO;
        this.sale = sale;
        this.productService = productService;
        this.product = product;
    }

    public List<SaleItem> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public SaleItem getById(Integer id) {
        return this.repository.findById(id).get();
    }




   /* public void createAll(SaleItemDTO dto, Sale sale){

        dto.
        Product p = this.productService.getById(dto.getId());
        SaleItem saleItem =
        SaleItem.builder().*/



}
