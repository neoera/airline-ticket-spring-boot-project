package com.finartz.apt.rest.api;

import com.finartz.apt.dto.*;
import com.finartz.apt.service.AirlineCompanyService;
import com.finartz.apt.util.web.BaseResponse;
import com.finartz.apt.viewobject.CreateAirlineCompanyRequest;
import com.finartz.apt.viewobject.CreateAirlineCompanyResponse;
import com.finartz.apt.viewobject.SearchAirlineCompanyRequest;
import com.finartz.apt.viewobject.SearchAirlineCompanyResponse;
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
 * {@link AirlineCompanyController}
 */

@RestController
@RequestMapping(value = "/airlineCompany")
@Scope("singleton")
@Api(value = "/airlineCompany", description = "Airline Company Controller")
public class AirlineCompanyController {

    private final AirlineCompanyService airlineCompanyService;

    Mapper dozerBeanMapper = new DozerBeanMapper();

    @Autowired
    public AirlineCompanyController(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateAirlineCompanyResponse>>create(@RequestBody CreateAirlineCompanyRequest createAirlineCompanyRequest) {
        CreateAirlineCompanyRequestDto createAirlineCompanyRequestDto = dozerBeanMapper.map(createAirlineCompanyRequest, CreateAirlineCompanyRequestDto.class);
        CreateAirlineCompanyResponseDto createAirlineCompanyResponseDto = airlineCompanyService.createAirlineCompany(createAirlineCompanyRequestDto);
        CreateAirlineCompanyResponse createAirlineCompanyResponse = dozerBeanMapper.map(createAirlineCompanyResponseDto, CreateAirlineCompanyResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createAirlineCompanyResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<SearchAirlineCompanyResponse>> search(@RequestBody SearchAirlineCompanyRequest searchAirlineCompanyRequest) {
        SearchAirlineCompanyResponse searchResultCompanyResponse = airlineCompanyService.searchAirlineCompany(searchAirlineCompanyRequest);
        return ResponseEntity.ok(new BaseResponse<>(searchResultCompanyResponse));

    }

}