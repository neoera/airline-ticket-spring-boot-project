package com.finartz.apt.service;

import com.finartz.apt.dto.CreateAirportRequestDto;
import com.finartz.apt.dto.CreateAirportResponseDto;
import com.finartz.apt.entity.Airport;
import com.finartz.apt.repository.AirportRepository;
import com.finartz.apt.viewobject.*;
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
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public CreateAirportResponseDto createAirport(CreateAirportRequestDto createAirportRequestDto) {
        Airport airport = new Airport();
        airport.setName(createAirportRequestDto.getName());
        airport.setCity(createAirportRequestDto.getCity());
        airport.setCountry(createAirportRequestDto.getCountry());
        airportRepository.save(airport);

        CreateAirportResponseDto createAirportResponseDto = new CreateAirportResponseDto();
        createAirportResponseDto.setAirportId(airport.getAirportId());
        createAirportResponseDto.setName(airport.getName());
        createAirportResponseDto.setCity(airport.getCity());
        createAirportResponseDto.setCountry(airport.getCountry());
        return createAirportResponseDto;
    }

    public SearchAirportResponse searchAirport(SearchAirportRequest searchAirportRequest) {
        Pageable pageable = PageRequest.of(searchAirportRequest.getPage(), searchAirportRequest.getSize());
        Page<Airport> airports = airportRepository.findAirportByName(searchAirportRequest.getName(), pageable);

        SearchAirportResponse searchAirportResponse = new SearchAirportResponse();
        List<SearchAirportResponse.AirportSummary> airportSummaryList = new ArrayList<>();

        if (!airports.isEmpty()) {
            for (Airport airlineCompany : airports) {
                SearchAirportResponse.AirportSummary airportSummary = new SearchAirportResponse.AirportSummary();
                airportSummary.setId(airlineCompany.getAirportId());
                airportSummary.setName(airlineCompany.getName());
                airportSummaryList.add(airportSummary);
            }
            searchAirportResponse.setAirlineCompanySummaryList(airportSummaryList);
            searchAirportResponse.setTotalPages(airports.getTotalPages());
            searchAirportResponse.setGetTotalElements(airports.getTotalElements());
        }

        return searchAirportResponse;

    }
}
