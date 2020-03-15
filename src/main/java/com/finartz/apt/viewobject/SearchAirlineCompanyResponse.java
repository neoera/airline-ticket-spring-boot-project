package com.finartz.apt.viewobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchAirlineCompanyResponse extends PageResult{

    List<AirlineCompanySummary> airlineCompanySummaryList;

    @Data
    public static class AirlineCompanySummary {
        private Long id;
        private String name;
        private String city;
        private String country;
    }
}
