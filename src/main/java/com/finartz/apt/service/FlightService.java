package com.finartz.apt.service;

import com.finartz.apt.dto.CreateFlightRequestDto;
import com.finartz.apt.dto.CreateFlightResponseDto;
import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.entity.Flight;
import com.finartz.apt.entity.Route;
import com.finartz.apt.repository.AirlineCompanyRepository;
import com.finartz.apt.repository.FlightRepository;
import com.finartz.apt.repository.RouteRepository;
import com.finartz.apt.viewobject.SearchFlightRequest;
import com.finartz.apt.viewobject.SearchFlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirlineCompanyRepository airlineCompanyRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, AirlineCompanyRepository airlineCompanyRepository, RouteRepository routeRepository) {
        this.flightRepository = flightRepository;
        this.airlineCompanyRepository = airlineCompanyRepository;
        this.routeRepository = routeRepository;
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public CreateFlightResponseDto createFlight(CreateFlightRequestDto createFlightRequestDto) {
        Flight flight = new Flight();

        AirlineCompany airlineCompany = airlineCompanyRepository.findByAirlineCode(createFlightRequestDto.getAirlineCompanyCode());
        Route route = routeRepository.findByRouteCode(createFlightRequestDto.getRouteCode());

        flight.setAirlineCompany(airlineCompany);
        flight.setRoute(route);
        flight.setFlightCode(createFlightRequestDto.getFlightCode());
        flight.setDuration(createFlightRequestDto.getDuration());
        flight.setArrivalTime(LocalTime.parse(createFlightRequestDto.getArrivalTime()));
        flight.setDepartureTime(LocalTime.parse(createFlightRequestDto.getDepartureTime()));
        flight.setAvailableSeats(createFlightRequestDto.getAvailableSeats());
        flight.setSeatPrice(createFlightRequestDto.getSeatPrice());
        try {
            flight.setArrivalDate(simpleDateFormat.parse(createFlightRequestDto.getArrivalDate()));
            flight.setDepartureDate(simpleDateFormat.parse(createFlightRequestDto.getDepartureDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flightRepository.save(flight);

        CreateFlightResponseDto createFlightResponseDto = new CreateFlightResponseDto();
        createFlightResponseDto.setFlightId(flight.getFlightId());
        createFlightResponseDto.setFlightCode(flight.getFlightCode());
        createFlightResponseDto.setAirlineCompanyCode(flight.getAirlineCompany().getAirlineCode());
        createFlightResponseDto.setRouteCode(flight.getRoute().getRouteCode());
        return createFlightResponseDto;
    }

    public SearchFlightResponse searchFlight(SearchFlightRequest searchFlightRequest) {
        Pageable pageable = PageRequest.of(searchFlightRequest.getPage(), searchFlightRequest.getSize());
        AirlineCompany airlineCompany = airlineCompanyRepository.findByAirlineCode(searchFlightRequest.getAirlineCompanyCode());
        Page<Flight> flights = flightRepository.findAllByAirlineCompany(airlineCompany, pageable);

        SearchFlightResponse searchFlightResponse = new SearchFlightResponse();
        List<SearchFlightResponse.FlightSummary> flightSummaryList = new ArrayList<>();

        if (!flights.isEmpty()) {
            for (Flight flight : flights) {
                SearchFlightResponse.FlightSummary flightSummary = new SearchFlightResponse.FlightSummary();
                flightSummary.setId(flight.getFlightId());
                flightSummary.setRouteCode(flight.getRoute().getRouteCode());
                flightSummary.setAirlineCompanyCode(flight.getAirlineCompany().getAirlineCode());
                flightSummary.setArrivalDate(flight.getArrivalDate().toString());
                flightSummary.setArrivalTime(flight.getArrivalTime().toString());
                flightSummary.setDepartureTime(flight.getDepartureTime().toString());
                flightSummary.setArrivalDate(simpleDateFormat.format(flight.getArrivalDate()));
                flightSummary.setDepartureDate(simpleDateFormat.format(flight.getDepartureDate()));
                flightSummary.setAvailableSeats(flight.getAvailableSeats());
                flightSummary.setDuration(flight.getDuration());
                flightSummary.setSeatPrice(flight.getSeatPrice());
                flightSummaryList.add(flightSummary);
            }
            searchFlightResponse.setFlightSummaryList(flightSummaryList);
            searchFlightResponse.setTotalPages(flights.getTotalPages());
            searchFlightResponse.setGetTotalElements(flights.getTotalElements());
        }

        return searchFlightResponse;

    }
}
