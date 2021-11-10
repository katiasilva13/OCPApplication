package com.triad.ocp.service.sale;

import com.triad.ocp.domain.sale.Sale;
import com.triad.ocp.domain.sale.dto.SaleDTO;
import com.triad.ocp.repository.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService implements Serializable {

    private final SaleRepository repository;

    @Autowired
    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public List<Sale> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Sale getById(Integer id) {
        return this.repository.findById(id).get();
    }
    

}
