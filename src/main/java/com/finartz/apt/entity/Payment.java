package com.finartz.apt.entity;

import com.finartz.apt.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PAYMENT")
public class Payment implements GenericEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSequence")
    @SequenceGenerator(sequenceName = "PAYMENT_SEQ", allocationSize = 1, name = "paymentSequence")
    @Column(name = "PAYMENT_ID", updatable = false, nullable = false)
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID", nullable = false)
    private Ticket ticket;

    @Column(name="DATE")
    private Date date;

    @Column(name="AMOUNT")
    private Double amount;

}