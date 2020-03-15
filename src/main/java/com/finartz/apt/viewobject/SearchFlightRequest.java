package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class SearchFlightRequest {
    private String routeCode;
    private String flightCode;
    private String airlineCompanyCode;
    private Integer page;
    private Integer size;
}
