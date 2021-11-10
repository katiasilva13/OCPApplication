package com.triad.ocp.service.sale;

import com.triad.ocp.domain.product.Product;
import com.triad.ocp.domain.sale.Sale;
import com.triad.ocp.domain.sale.SaleItem;
import com.triad.ocp.domain.sale.dto.SaleItemDTO;
import com.triad.ocp.repository.sale.SaleItemRepository;
import com.triad.ocp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SaleItemService implements Serializable {

    public final ProductService productService;
    private SaleItemRepository repository;

    @Autowired
    public SaleItemService(ProductService productService, SaleItemRepository repository) {
        this.productService = productService;
        this.repository = repository;
    }

    public List<SaleItem> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public SaleItem getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public void createAll(List<SaleItemDTO> saleItems, Sale sale) {
        for(SaleItemDTO item : saleItems){
            Product p = this.productService.getById(item.getProductId());
            SaleItem saleItem = SaleItem.builder()
                    .count(item.getCount())
                    .value(item.getValue())
                    .sale(sale)
                    .build();
            this.repository.save(saleItem);
        }
    }

}
