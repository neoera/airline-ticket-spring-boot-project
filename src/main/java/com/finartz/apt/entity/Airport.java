package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="AIRPORT")
public class Airport implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportSequence")
    @SequenceGenerator(sequenceName = "AIRPORT_SEQ", allocationSize = 1, name = "airportSequence")
    @Column(name = "AIRPORT_ID", updatable = false, nullable = false)
    private Long airportId;

    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ROUTE_ID")
    private List<Route> routes;*/

    @Column(name="CODE", length=50, nullable=false)
    private String code;

    @Column(name="NAME", length=50, nullable=false)
    private String name;

    @Column(name="CITY", length=50, nullable=false)
    private String city;

    @Column(name="COUNTRY", length=50, nullable=false)
    private String country;

}