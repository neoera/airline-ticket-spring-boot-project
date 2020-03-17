package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FLIGHT")
public class Flight implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSequence")
    @SequenceGenerator(sequenceName = "FLIGHT_SEQ", allocationSize = 1, name = "flightSequence")
    @Column(name = "FLIGHT_ID", updatable = false, nullable = false)
    private Long flightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRLINE_COMPANY_ID", nullable = false)
    private AirlineCompany airlineCompany;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private Set<Ticket> tickets;

    @Column(name="FLIGHT_CODE", length=50, nullable=false)
    private String flightCode;

    @Column(name="TOTAL_SEATS")
    private Integer totalSeats;

    @Column(name="AVAILABLE_SEATS")
    private Integer availableSeats;

    @Column(name="DURATION")
    private String duration;

    @Column(name="ARRIVAL_TIME", nullable=false)
    private LocalTime arrivalTime;

    @Column(name="DEPARTURE_TIME", nullable=false)
    private LocalTime departureTime;

    @Column(name="ARRIVAL_DATE", nullable=false)
    private Date arrivalDate;

    @Column(name="DEPARTURE_DATE", nullable=false)
    private Date departureDate;

    @Column(name="SEAT_PRICE")
    private Double seatPrice;
}