package com.finartz.apt.repository;

import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.entity.Flight;
import com.finartz.apt.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Flight Repository
 */
public interface FlightRepository extends BaseJpaRepository<Flight, Long> {

    Page<Flight> findAllByAirlineCompany(AirlineCompany airlineCompany, Pageable pageable);

    Flight findByFlightCode(String code);

}
