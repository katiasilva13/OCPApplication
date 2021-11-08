package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.domain.person.Employee;
import com.triad.ocp.domain.person.Person;
import com.triad.ocp.domain.person.dto.EmployeeDTO;
import com.triad.ocp.enumerator.Role;
import com.triad.ocp.enumerator.Uf;
import com.triad.ocp.repository.person.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmployeeService implements Serializable {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Employee getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Employee> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Employee create(EmployeeDTO dto) {
        Address address = Address.builder()
                .cep(dto.getCep())
                .city(dto.getCity())
                .neighborhood(dto.getNeighborhood())
                .number(dto.getNumber())
                .street(dto.getStreet())
                .uf(Uf.valueOf(dto.getUf()))
                .build();
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