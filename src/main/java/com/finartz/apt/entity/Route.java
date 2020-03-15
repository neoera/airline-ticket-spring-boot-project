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
@Table(name="ROUTE")
class Route implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routeSequence")
    @SequenceGenerator(sequenceName = "ROUTE_SEQ", allocationSize = 1, name = "routeSequence")
    @Column(name = "ROUTE_ID", updatable = false, nullable = false)
    private Long routeId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private Set<Flight> flights;

    @Column(name="CODE", length=50, nullable=false)
    private String code;

    @OneToOne(mappedBy = "originRoute")
    @JoinColumn(name = "ORIGIN_AIRPORT_ID", referencedColumnName = "AIRPORT_ID", nullable = false)
    private Airport originAirport;

    @OneToOne(mappedBy = "destinationRoute")
    @JoinColumn(name = "DESTINATION_AIRPORT_ID", referencedColumnName = "AIRPORT_ID", nullable = false)
    private Airport destinationAirport;

}