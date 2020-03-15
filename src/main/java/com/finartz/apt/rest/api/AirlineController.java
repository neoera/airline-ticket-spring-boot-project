package com.finartz.apt.rest.api;

import com.finartz.apt.dto.CreateAirlineRequestDto;
import com.finartz.apt.dto.CreateAirlineResponseDto;
import com.finartz.apt.service.AirlineService;
import com.finartz.apt.util.web.BaseResponse;
import com.finartz.apt.viewobject.CreateAirlineCompanyRequest;
import com.finartz.apt.viewobject.CreateAirlineCompanyResponse;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

/**
 * {@link AirlineController}
 */

@RestController
public class AirlineController {

    private final AirlineService airlineService;
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @RequestMapping(value = "/createAirlineCompany", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateAirlineCompanyResponse>>addAirline(@RequestBody CreateAirlineCompanyRequest createAirlineCompanyRequest) throws Exception{
        CreateAirlineRequestDto createAirlineRequestDto = dozerBeanMapper.map(createAirlineCompanyRequest, CreateAirlineRequestDto.class);
        CreateAirlineResponseDto createAirlineResponseDto = airlineService.createAirline(createAirlineRequestDto);
        CreateAirlineCompanyResponse createAirlineCompanyResponse = dozerBeanMapper.map(createAirlineResponseDto, CreateAirlineCompanyResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createAirlineCompanyResponse));
    }

}