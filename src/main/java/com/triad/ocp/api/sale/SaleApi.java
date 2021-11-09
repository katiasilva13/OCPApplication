package com.triad.ocp.api.sale;

import com.triad.ocp.service.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SaleApi {

    private final SaleService service;

    @Autowired
    public SaleApi(SaleService service) {
        this.service = service;
    }

    @GetMapping("/vendas")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

//    @PostMapping("/vendas")
//    public ResponseEntity create(@RequestBody SaleDTO dto) {
//        return ResponseEntity.ok(this.service.create(dto));
//    }
//
//    @PostMapping("/vendas/cancelar/{id}")
//    public ResponseEntity cancel(@PathVariable Integer id) {
//        return ResponseEntity.ok(this.service.cancel(id));
//    }
//
//    @PostMapping("/vendas/finalizar/{id}")
//    public ResponseEntity finish(@PathVariable Integer id) {
//        return ResponseEntity.ok(this.service.finish(id));
//    }
}
