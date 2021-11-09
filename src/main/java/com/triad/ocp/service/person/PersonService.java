package com.triad.ocp.service.person;

import com.triad.ocp.domain.person.Person;
import com.triad.ocp.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonService implements Serializable {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Person getById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Transactional
    public List<Person> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }
}
