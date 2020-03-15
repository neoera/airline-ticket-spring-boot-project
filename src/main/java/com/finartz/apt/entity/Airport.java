package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="AIRPORT")
class Airport implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportSequence")
    @SequenceGenerator(sequenceName = "AIRPORT_SEQ", allocationSize = 1, name = "airportSequence")
    @Column(name = "AIRPORT_ID", updatable = false, nullable = false)
    private Long airportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORIGIN_ROUTE_ID", referencedColumnName = "ROUTE_ID", nullable = false)
    private Route originRoute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESTINATION_ROUTE_ID", referencedColumnName = "ROUTE_ID", nullable = false)
    private Route destinationRoute;

    @Column(name="NAME", length=50, nullable=false)
    private String name;

    @Column(name="CITY", length=50, nullable=false)
    private String city;

    @Column(name="COUNTRY", length=50, nullable=false)
    private String country;

}