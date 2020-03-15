package com.finartz.apt.rest.api;

import com.finartz.apt.dto.CreateRouteRequestDto;
import com.finartz.apt.dto.CreateRouteResponseDto;
import com.finartz.apt.service.RouteService;
import com.finartz.apt.util.web.BaseResponse;
import com.finartz.apt.viewobject.CreateRouteRequest;
import com.finartz.apt.viewobject.CreateRouteResponse;
import com.finartz.apt.viewobject.PageResult;
import com.finartz.apt.viewobject.SearchRouteRequest;
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
 * {@link RouteController}
 */

@RestController
@RequestMapping(value = "/route")
@Scope("singleton")
@Api(value = "/route", description = "Route Controller")
public class RouteController {

    private final RouteService routeService;

    Mapper dozerBeanMapper = new DozerBeanMapper();

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateRouteResponse>>create(@RequestBody CreateRouteRequest createRouteRequest) {
        CreateRouteRequestDto createRouteRequestDto = dozerBeanMapper.map(createRouteRequest, CreateRouteRequestDto.class);
        CreateRouteResponseDto createRouteResponseDto = routeService.createRoute(createRouteRequestDto);
        CreateRouteResponse createRouteResponse = dozerBeanMapper.map(createRouteResponseDto, CreateRouteResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createRouteResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<PageResult>> search(@RequestBody SearchRouteRequest searchRouteRequest) {
        PageResult searchResultTicketResponse = routeService.searchRoute(searchRouteRequest);
        return ResponseEntity.ok(new BaseResponse<>(searchResultTicketResponse));

    }

}