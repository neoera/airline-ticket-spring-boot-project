package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateRouteResponse {
    private Long routeId;
    private String routeCode;
    private String originAirport;
    private String destinationAirport;
}
