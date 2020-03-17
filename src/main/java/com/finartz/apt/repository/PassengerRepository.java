package com.finartz.apt.repository;

import com.finartz.apt.entity.Passenger;
import com.finartz.apt.entity.Ticket;
import com.finartz.apt.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * PassengerDto Repository
 */
public interface PassengerRepository extends BaseJpaRepository<Passenger, Long> {

    Passenger findByIdentityNumber(Long identityNumber);

}
