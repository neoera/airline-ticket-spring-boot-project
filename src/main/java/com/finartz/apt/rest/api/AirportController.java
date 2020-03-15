package com.finartz.apt.rest.api;

import com.finartz.apt.dto.CreateAirportRequestDto;
import com.finartz.apt.dto.CreateAirportResponseDto;
import com.finartz.apt.service.AirportService;
import com.finartz.apt.util.web.BaseResponse;
import com.finartz.apt.viewobject.*;
import io.swagger.annotations.Api;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

/**
 * {@link AirportController}
 */

@RestController
@RequestMapping(value = "/airport")
@Scope("singleton")
@Api(value = "/airport", description = "Airport Controller")
public class AirportController {

    private final AirportService airportService;

    Mapper dozerBeanMapper = new DozerBeanMapper();

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateAirportResponse>>create(@RequestBody CreateAirportRequest createAirportRequest) {
        CreateAirportRequestDto createAirportRequestDto = dozerBeanMapper.map(createAirportRequest, CreateAirportRequestDto.class);
        CreateAirportResponseDto createAirportResponseDto = airportService.createAirport(createAirportRequestDto);
        CreateAirportResponse createAirportResponse = dozerBeanMapper.map(createAirportResponseDto, CreateAirportResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createAirportResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<PageResult>> search(@RequestBody SearchAirportRequest searchAirportRequest) {
        PageResult searchResultAirportResponse = airportService.searchAirport(searchAirportRequest);
        return ResponseEntity.ok(new BaseResponse<>(searchResultAirportResponse));

    }

}