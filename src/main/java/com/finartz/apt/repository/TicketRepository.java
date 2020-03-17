package com.finartz.apt.repository;

import com.finartz.apt.entity.Ticket;
import com.finartz.apt.repository.base.BaseJpaRepository;

/**
 * Ticket Repository
 */
public interface TicketRepository extends BaseJpaRepository<Ticket, Long> {

    Ticket findByNumber(Long name);

}
