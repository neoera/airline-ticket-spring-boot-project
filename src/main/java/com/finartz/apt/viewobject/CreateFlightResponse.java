package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateFlightResponse {
    private Long flightId;
    private String routeCode;
    private String airlineCompanyCode;
    private String flightCode;
}
