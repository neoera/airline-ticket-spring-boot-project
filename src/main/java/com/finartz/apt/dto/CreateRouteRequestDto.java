package com.finartz.apt.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateRouteRequestDto {
    private String routeCode;
    private String originAirportCode;
    private String destinationAirportCode;
}
