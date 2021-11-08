package com.triad.ocp.api.person;

import com.triad.ocp.domain.person.dto.ClientDTO;
import com.triad.ocp.service.person.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ClientApi {

    @Autowired
    private ClientService service;

    @GetMapping("/clientes")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.deleteById(id));
    }

    @PostMapping("/clientes")
    public ResponseEntity create(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }
}
