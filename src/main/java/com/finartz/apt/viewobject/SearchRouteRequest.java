package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class SearchRouteRequest {
    private String routeCode;
    private String originAirportName;
    private String destinationAirportName;
    private Integer page;
    private Integer size;
}
