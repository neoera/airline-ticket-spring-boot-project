package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class SearchAirlineCompanyRequest {
    private String name;
    private Integer page;
    private Integer size;
}
