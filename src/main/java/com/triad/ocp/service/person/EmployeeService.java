package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Employee;
import com.triad.ocp.domain.person.dto.EmployeeDTO;
import com.triad.ocp.enumerator.Role;
import com.triad.ocp.repository.person.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class EmployeeService implements Serializable {

    private final EmployeeRepository repository;
    private final AddressService addressService;

    @Autowired
    public EmployeeService(EmployeeRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public List<Employee> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Employee getById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Transactional
    public List<Employee> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    @Transactional
    public Employee create(EmployeeDTO dto) {
        Address address =  this.addressService.create(
                dto.getCep(),
                dto.getCity(),
                dto.getNeighborhood(),
                dto.getNumber(),
                dto.getStreet(),
                dto.getUf());
        Employee person = Employee.builder()
                .cpf(dto.getCpf())
                .role(Role.valueOf(dto.getRole()))
                .build();
        person.setAddress(address);
        person.setName(dto.getName());
        person.setPhoneNumber(dto.getPhoneNumber());
        return this.repository.save(person);
    }
}