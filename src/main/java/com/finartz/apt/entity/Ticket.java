package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TICKET")
public class Ticket implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSequence")
    @SequenceGenerator(sequenceName = "TICKET_SEQ", allocationSize = 1, name = "ticketSequence")
    @Column(name = "TICKET_ID", updatable = false, nullable = false)
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PASSENGER_ID", nullable = false)
    private Passenger passenger;

    @Column(name="NUMBER", unique = true)
    private Long number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ticket")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLIGHT_ID", nullable = false)
    private Flight flight;

    @Column(name="STATUS")
    private String status;

    @Column(name="SEAT_NUMBER")
    private int seatNumber;

}