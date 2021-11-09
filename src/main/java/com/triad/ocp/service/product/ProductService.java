package com.triad.ocp.service.product;

import com.triad.ocp.domain.product.Product;
import com.triad.ocp.domain.product.dto.ProductDTO;
import com.triad.ocp.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ProductService implements Serializable {

    private final ProductRepository repository;
    
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Product getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    public Product create(ProductDTO dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .build();
            product.setQuantity(dto.getQuantity());
            product.setPriceBuy(dto.getPriceBuy());
            product.setPriceSale(dto.getPriceSale());
        return this.repository.save(product);
    }
}