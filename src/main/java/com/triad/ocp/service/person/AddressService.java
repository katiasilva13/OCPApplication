package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.enumerator.Uf;
import com.triad.ocp.repository.person.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AddressService implements Serializable {

    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("uf")));
    }

    public Address getById(Integer id) {
        return this.repository.findById(id).get();
    }


    public Address create(String cep, String city, String neighborhood, String number, String street, String uf) {
        Address address = Address.builder()
                .cep(cep)
                .city(city)
                .neighborhood(neighborhood)
                .number(number)
                .street(street)
                .uf(Uf.valueOf(uf))
                .build();
        return repository.save(address);
    }
}
