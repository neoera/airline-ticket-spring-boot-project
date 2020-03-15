package com.finartz.apt.repository;

import com.finartz.apt.entity.Ticket;
import com.finartz.apt.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Ticket Repository
 */
public interface TicketRepository extends BaseJpaRepository<Ticket, Long> {

    Page<Ticket> findByNumber(String name, Pageable pageable);

}
