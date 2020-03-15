package com.finartz.apt.dto;

import lombok.Data;

@Data
public class CreateRouteResponseDto {
    private Long routeId;
    private String routeCode;
    private String originAirportCode;
    private String originAirportName;
    private String destinationAirportCode;
    private String destinationAirportName;
}
