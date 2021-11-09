package com.triad.ocp.api.product;

import com.triad.ocp.domain.product.dto.ProductDTO;
import com.triad.ocp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductAPI {

    private final ProductService service;

    @Autowired
    public ProductAPI(ProductService service) {
        this.service = service;
    }

    @GetMapping("/produtos")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        this.service.deleteById(id);
        return ResponseEntity.ok("Produto excluido");
    }

    @PostMapping("/produtos")
    public ResponseEntity create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }
    
}
