package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateRouteRequest {
    private String routeCode;
    private String originAirport;
    private String destinationAirport;
}
