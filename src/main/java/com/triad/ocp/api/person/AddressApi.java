package com.triad.ocp.api.person;

import com.triad.ocp.service.person.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AddressApi {
    @Autowired
    private AddressService service;

    public AddressApi(AddressService service) {
        this.service = service;
    }

    @GetMapping("/enderecos")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

}
