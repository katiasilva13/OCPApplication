package com.triad.ocp.domain.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.triad.ocp.domain.AbstractEntity;
import com.triad.ocp.enumerator.Uf;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Address extends AbstractEntity {
    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "cep")
    private String cep;

    @Column
    @Enumerated(EnumType.STRING)
    private Uf uf;
}
