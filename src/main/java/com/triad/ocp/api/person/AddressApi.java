package com.triad.ocp.api.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.service.person.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AddressApi {
    @Autowired
    private AddressService service;

    @GetMapping("/enderecos")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.deleteById(id));
    }

}
