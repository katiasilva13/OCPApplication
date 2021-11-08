package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Company;
import com.triad.ocp.domain.person.dto.CompanyDTO;
import com.triad.ocp.repository.person.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CompanyService implements Serializable {

    private final CompanyRepository repository;
    private final AddressService addressService;

    @Autowired
    public CompanyService(CompanyRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public Company getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public Company create(CompanyDTO dto) {
        Address address =  this.addressService.create(
                dto.getCep(),
                dto.getCity(),
                dto.getNeighborhood(),
                dto.getNumber(),
                dto.getStreet(),
                dto.getUf());
        Company person = Company.builder()
                .cnpj(dto.getCnpj())
                .corporateName(dto.getCorporateName())
                .build();
        person.setAddress(address);
        person.setName(dto.getName());
        person.setPhoneNumber(dto.getPhoneNumber());
        return this.repository.save(person);
    }
}