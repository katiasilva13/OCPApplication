package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Client;
import com.triad.ocp.domain.person.Employee;
import com.triad.ocp.domain.person.dto.ClientDTO;
import com.triad.ocp.domain.person.dto.EmployeeDTO;
import com.triad.ocp.enumerator.Role;
import com.triad.ocp.enumerator.Uf;
import com.triad.ocp.repository.person.ClientRepository;
import com.triad.ocp.repository.person.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ClientService implements Serializable {

    @Autowired
    private ClientRepository repository;

    public List<Client> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Client getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Client> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Client create(ClientDTO dto) {
        Address address = Address.builder()
                .cep(dto.getCep())
                .city(dto.getCity())
                .neighborhood(dto.getNeighborhood())
                .number(dto.getNumber())
                .street(dto.getStreet())
                .uf(Uf.valueOf(dto.getUf()))
                .build();
        Client person = Client.builder()
                .cpf(dto.getCpf())
                .rg(dto.getRg())
                .build();
        person.setAddress(address);
        person.setName(dto.getName());
        person.setPhoneNumber(dto.getPhoneNumber());
        this.repository.save(person);
        return person;
    }
}