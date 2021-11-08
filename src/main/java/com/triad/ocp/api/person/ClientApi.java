package com.triad.ocp.api.person;

import com.triad.ocp.domain.person.dto.EmployeeDTO;
import com.triad.ocp.service.person.EmployeeService;
import com.triad.ocp.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EmployeeApi {

    @Autowired
    private EmployeeService service;

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

    @PostMapping("/usuarios")
    public ResponseEntity create(@RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }
}
