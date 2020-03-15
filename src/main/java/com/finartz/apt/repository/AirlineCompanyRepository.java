package com.finartz.apt.repository;

import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Airline Company Repository
 */
public interface AirlineCompanyRepository extends BaseJpaRepository<AirlineCompany, Long> {

    Page<AirlineCompany> findByAirlineCompanyId(int airlineCompanyId, Pageable pageable);

}
