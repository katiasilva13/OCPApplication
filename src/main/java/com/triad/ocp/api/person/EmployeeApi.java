package com.triad.ocp.api.person;

import com.triad.ocp.domain.person.dto.EmployeeDTO;
import com.triad.ocp.service.person.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EmployeeApi {

    private final EmployeeService service;

    @Autowired
    public EmployeeApi(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/funcionarios")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.deleteById(id));
    }

    @PostMapping("/funcionarios")
    public ResponseEntity create(@RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }
}
