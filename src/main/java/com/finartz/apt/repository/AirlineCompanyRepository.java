package com.finartz.apt.repository;

import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.repository.base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Airline Company Repository
 */
public interface AirlineCompanyRepository extends BaseJpaRepository<AirlineCompany, Long> {

    AirlineCompany findByAirlineCode(String code);

    @Query(value = "select * from AIRLINE_COMPANY where name like %?1%", nativeQuery = true)
    Page<AirlineCompany> findAirlineCompanyByName(String name, Pageable pageable);

}
