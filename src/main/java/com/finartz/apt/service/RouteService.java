package com.finartz.apt.service;

import com.finartz.apt.dto.CreateRouteRequestDto;
import com.finartz.apt.dto.CreateRouteResponseDto;
import com.finartz.apt.entity.Airport;
import com.finartz.apt.entity.Route;
import com.finartz.apt.repository.AirportRepository;
import com.finartz.apt.repository.RouteRepository;
import com.finartz.apt.viewobject.SearchRouteRequest;
import com.finartz.apt.viewobject.SearchRouteResponse;
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
public class RouteService {

    private final RouteRepository routeRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository, AirportRepository airportRepository) {
        this.routeRepository = routeRepository;
        this.airportRepository = airportRepository;
    }

    public CreateRouteResponseDto createRoute(CreateRouteRequestDto createRouteRequestDto) {
        Route route = new Route();

        Airport originAirport = airportRepository.findByCode(createRouteRequestDto.getOriginAirportCode());
        Airport destinationAirport = airportRepository.findByCode(createRouteRequestDto.getDestinationAirportCode());

        route.setOriginAirport(originAirport);
        route.setDestinationAirport(destinationAirport);
        routeRepository.save(route);

        CreateRouteResponseDto createRouteResponseDto = new CreateRouteResponseDto();
        createRouteResponseDto.setRouteId(route.getRouteId());
        createRouteResponseDto.setRouteCode(route.getRouteCode());
        createRouteResponseDto.setOriginAirportName(route.getOriginAirport().getName());
        createRouteResponseDto.setDestinationAirportName(route.getDestinationAirport().getName());
        return createRouteResponseDto;
    }

    public SearchRouteResponse searchRoute(SearchRouteRequest searchRouteRequest) {
        Pageable pageable = PageRequest.of(searchRouteRequest.getPage(), searchRouteRequest.getSize());
        Page<Route> routes = routeRepository.findByRouteCode(searchRouteRequest.getRouteCode(), pageable);

        SearchRouteResponse searchRouteResponse = new SearchRouteResponse();
        List<SearchRouteResponse.RouteSummary> routeSummaryList = new ArrayList<>();

        if (!routes.isEmpty()) {
            for (Route route : routes) {
                SearchRouteResponse.RouteSummary routeSummary = new SearchRouteResponse.RouteSummary();
                routeSummary.setId(route.getRouteId());
                routeSummary.setRouteCode(route.getRouteCode());
                routeSummary.setOriginAirportName(route.getOriginAirport().getName());
                routeSummary.setDestinationAirportName(route.getDestinationAirport().getName());
                routeSummaryList.add(routeSummary);
            }
            searchRouteResponse.setRouteSummaryList(routeSummaryList);
            searchRouteResponse.setTotalPages(routes.getTotalPages());
            searchRouteResponse.setGetTotalElements(routes.getTotalElements());
        }

        return searchRouteResponse;
    }
}
