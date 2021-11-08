package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Client;
import com.triad.ocp.domain.person.Company;
import com.triad.ocp.domain.person.dto.ClientDTO;
import com.triad.ocp.domain.person.dto.CompanyDTO;
import com.triad.ocp.enumerator.Uf;
import com.triad.ocp.repository.person.ClientRepository;
import com.triad.ocp.repository.person.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CompanyService implements Serializable {

    @Autowired
    private CompanyRepository repository;

    public Company getById(Integer id) {
        return this.repository.findById(id).get();
    }
    public Company create(CompanyDTO dto) {
        Address address = Address.builder()
                .cep(dto.getCep())
                .city(dto.getCity())
                .neighborhood(dto.getNeighborhood())
                .number(dto.getNumber())
                .street(dto.getStreet())
                .uf(Uf.valueOf(dto.getUf()))
                .build();
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