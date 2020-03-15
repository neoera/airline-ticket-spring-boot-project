package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateAirportRequest {
    private String name;
    private String city;
    private String country;
}
