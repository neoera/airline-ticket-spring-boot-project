package com.finartz.apt.service;

import com.finartz.apt.dto.*;
import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.repository.AirlineCompanyRepository;
import com.finartz.apt.viewobject.SearchAirlineCompanyRequest;
import com.finartz.apt.viewobject.SearchAirlineCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AirlineCompanyService {

    private final AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    public AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public CreateAirlineCompanyResponseDto createAirlineCompany(CreateAirlineCompanyRequestDto createAirlineCompanyRequestDto) {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setName(createAirlineCompanyRequestDto.getName());
        airlineCompanyRepository.save(airlineCompany);

        CreateAirlineCompanyResponseDto createAirlineCompanyResponseDto = new CreateAirlineCompanyResponseDto();
        createAirlineCompanyResponseDto.setAirlineCompanyId(airlineCompany.getAirlineCompanyId());
        createAirlineCompanyResponseDto.setName(airlineCompany.getName());
        return createAirlineCompanyResponseDto;
    }

    public SearchAirlineCompanyResponse searchAirlineCompany(SearchAirlineCompanyRequest searchAirlineCompanyRequest) {

        Pageable pageable = PageRequest.of(searchAirlineCompanyRequest.getPage(), searchAirlineCompanyRequest.getSize());
        Page<AirlineCompany> airlineCompanies = airlineCompanyRepository.findAirlineCompanyByName(searchAirlineCompanyRequest.getName(), pageable);

        SearchAirlineCompanyResponse searchAirlineCompanyResponse = new SearchAirlineCompanyResponse();
        List<SearchAirlineCompanyResponse.AirlineCompanySummary> searchAirlineCompanyResponseList = new ArrayList<>();

        if (!airlineCompanies.isEmpty()) {
            for (AirlineCompany airlineCompany : airlineCompanies) {
                SearchAirlineCompanyResponse.AirlineCompanySummary airlineCompanySummary = new SearchAirlineCompanyResponse.AirlineCompanySummary();
                airlineCompanySummary.setId(airlineCompany.getAirlineCompanyId());
                airlineCompanySummary.setName(airlineCompany.getName());
                searchAirlineCompanyResponseList.add(airlineCompanySummary);
            }
            searchAirlineCompanyResponse.setAirlineCompanySummaryList(searchAirlineCompanyResponseList);
            searchAirlineCompanyResponse.setTotalPages(airlineCompanies.getTotalPages());
            searchAirlineCompanyResponse.setGetTotalElements(airlineCompanies.getTotalElements());
        }

        return searchAirlineCompanyResponse;

    }
}
