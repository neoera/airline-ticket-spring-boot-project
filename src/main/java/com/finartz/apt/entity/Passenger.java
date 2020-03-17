package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PASSENGER")
public class Passenger implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerSequence")
    @SequenceGenerator(sequenceName = "PASSENGER_SEQ", allocationSize = 1, name = "passengerSequence")
    @Column(name = "PASSENGER_ID", updatable = false, nullable = false)
    private Long passengerId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger")
    private Set<Ticket> tickets;

    @Column(name = "IDENTITY_NUMBER", nullable = false)
    private Long identityNumber;

    @Column(name="NAME", length=50, nullable=false)
    private String name;

    @Column(name="SURNAME", length=50, nullable=false)
    private String surname;

    @Column(name="ADDRESS", length=50, nullable=false)
    private String address;

    @Column(name="TELEPHONE_NUMBER", length=50, nullable=false)
    private int telephoneNumber;

    @Column(name="EMAIL", length=50, nullable=false)
    private String email;

    @Column(name="DATE_OF_BIRTH", length=50, nullable=false)
    private Date dateOfBirth;

}