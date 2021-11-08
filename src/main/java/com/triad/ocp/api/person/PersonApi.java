package com.triad.ocp.api.person;

import com.triad.ocp.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PersonApi {

    @Autowired
    private PersonService service;

    public PersonApi(PersonService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.deleteById(id));
    }
}
