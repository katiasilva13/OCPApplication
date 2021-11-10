package com.triad.ocp.service.sale;

import com.triad.ocp.service.person.ClientService;
import com.triad.ocp.service.person.EmployeeService;
import com.triad.ocp.domain.sale.Sale;

import com.triad.ocp.domain.sale.dto.SaleDTO;
import com.triad.ocp.repository.sale.SaleRepository;
import com.triad.ocp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class SaleService implements Serializable {

    private final SaleRepository repository;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final ProductService productService;
    private final SaleItemService saleItemService;

    @Autowired
    public SaleService(SaleRepository repository, EmployeeService employeeService, ClientService clientService, ProductService productService, SaleItemService saleItemService) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.productService = productService;
        this.saleItemService = saleItemService;
    }

    public List<Sale> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Sale getById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Transactional
    public Object create(SaleDTO dto) {
        Sale sale = Sale.builder()
                .discount(dto.getDiscount())
                .subtotal(dto.getSubtotal())
                .total(dto.getTotal())
                .moment(dto.getMoment())
                .build();
                if (Objects.nonNull(dto.getEmployeeId()))sale.setEmployee(employeeService.getById(dto.getEmployeeId()));
                if (Objects.nonNull(dto.getClientId())) sale.setClient(clientService.getById(dto.getClientId()));

                sale = this.repository.save(sale);
                this.saleItemService.createAll(dto.getSaleItems(), sale);

        return this.repository.save(sale);
    }
}
