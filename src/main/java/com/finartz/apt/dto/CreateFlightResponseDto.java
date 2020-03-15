package com.finartz.apt.dto;

import lombok.Data;

@Data
public class CreateFlightResponseDto {
    private Long flightId;
    private String routeCode;
    private String airlineCompanyCode;
    private String flightCode;
}
