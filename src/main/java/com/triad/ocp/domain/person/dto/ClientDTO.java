package com.triad.ocp.domain.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String cep;
    private String uf;
    private String cpf;
    private String rg;
}
