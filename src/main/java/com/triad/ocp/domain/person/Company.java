package com.triad.ocp.domain.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "company_id")
@Entity
@Table
public class Company extends Person{
    @Column(name = "corporate_name")
    private String corporateName;

    @Column(name = "name")
    private String cnpj;
}
