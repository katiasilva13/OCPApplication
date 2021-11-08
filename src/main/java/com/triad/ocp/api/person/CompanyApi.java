package com.triad.ocp.api.person;

import com.triad.ocp.domain.person.dto.ClientDTO;
import com.triad.ocp.domain.person.dto.CompanyDTO;
import com.triad.ocp.service.person.ClientService;
import com.triad.ocp.service.person.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CompanyApi {

    @Autowired
    private CompanyService service;

    @GetMapping("/empresa/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @PostMapping("/empresa")
    public ResponseEntity create(@RequestBody CompanyDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }
}
