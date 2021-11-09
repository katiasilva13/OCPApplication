package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Client;
import com.triad.ocp.domain.person.dto.ClientDTO;
import com.triad.ocp.repository.person.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class ClientService implements Serializable {

    private final ClientRepository repository;
    private final AddressService addressService;

    @Autowired
    public ClientService(ClientRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public List<Client> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Client getById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Transactional
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Transactional
    public Client create(ClientDTO dto) {
        Address address =  this.addressService.create(
                dto.getCep(),
                dto.getCity(),
                dto.getNeighborhood(),
                dto.getNumber(),
                dto.getStreet(),
                dto.getUf());
        Client person = Client.builder()
                .cpf(dto.getCpf())
                .rg(dto.getRg())
                .build();
        person.setAddress(address);
        person.setName(dto.getName());
        person.setPhoneNumber(dto.getPhoneNumber());
        return this.repository.save(person);
    }
}