package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="AIRLINE_COMPANY")
public class AirlineCompany implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airlineCompanySequence")
    @SequenceGenerator(sequenceName = "AIRLINE_COMPANY_SEQ", allocationSize = 1, name = "airlineCompanySequence")
    @Column(name = "AIRLINE_COMPANY_ID", updatable = false, nullable = false)
    private Long airlineCompanyId;

    @Column(name="AIRLINE_COMPANY_CODE", length=50, nullable=false)
    private String airlineCode;

    @Column(name="NAME", length=50, nullable=false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airlineCompany")
    private List<Flight> flights;

}