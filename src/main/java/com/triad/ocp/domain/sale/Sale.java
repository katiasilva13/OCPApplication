package com.triad.ocp.domain.sale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.triad.ocp.domain.person.Client;
import com.triad.ocp.domain.person.Employee;
import com.triad.ocp.enumerator.Role;
import com.triad.ocp.enumerator.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Builder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "total")
    private Double total;

    @Column(name = "moment")
    private LocalDateTime moment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = true)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = true)
    private Client client;

    @Column
    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus = SaleStatus.ABERTA;
}
