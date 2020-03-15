package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class SearchAirportRequest {
    private String name;
    private String city;
    private String country;
    private Integer page;
    private Integer size;
}
