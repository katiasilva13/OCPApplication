package com.triad.ocp.service.sale;

import com.triad.ocp.domain.product.Product;
import com.triad.ocp.domain.sale.Sale;
import com.triad.ocp.domain.sale.SaleItem;
import com.triad.ocp.repository.sale.SaleItemRepository;
import com.triad.ocp.service.product.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SaleItemService implements Serializable {

    public final SaleItem saleItem;
    public final Sale sale;
    public final ProductService productService;
    private final Product product;
    private SaleItemRepository repository;

    public SaleItemService(SaleItem saleItem, Sale sale, ProductService productService, Product product) {
        this.saleItem = saleItem;
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

    public void createAll(List<SaleItem> saleItems, Sale sale) {

        for(SaleItem item : saleItems){
            Product p = this.productService.getById(item.getId());
            SaleItem saleItem = SaleItem.builder()
                    .count(item.getCount())
                    .value(item.getValue())
                    .sale(sale)
                    .build();
            this.repository.save(saleItem);
        }
    }

}
