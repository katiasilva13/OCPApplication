package com.triad.ocp.domain.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.triad.ocp.enumerator.Role;
import com.triad.ocp.enumerator.Uf;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "employee_id")
@Entity
@Table
public class Employee extends Person {
    @Column(name = "name")
    private String cpf;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
