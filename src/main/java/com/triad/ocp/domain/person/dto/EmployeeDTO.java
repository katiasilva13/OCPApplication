package com.triad.ocp.domain.person.dto;

import com.triad.ocp.domain.person.Address;
import com.triad.ocp.enumerator.Uf;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PersonDTO {
    private String name;
    private String phoneNumber;

    private Address address;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String cep;

    private String uf;
}
