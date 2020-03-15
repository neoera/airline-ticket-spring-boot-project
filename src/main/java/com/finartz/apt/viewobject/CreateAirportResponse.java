package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateAirportResponse {
    private Long airportId;
    private String name;
    private String city;
    private String country;
}
