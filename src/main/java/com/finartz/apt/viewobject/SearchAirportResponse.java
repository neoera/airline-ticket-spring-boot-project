package com.finartz.apt.viewobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchAirportResponse extends PageResult{

    List<AirportSummary> airlineCompanySummaryList;

    @Data
    public static class AirportSummary {
        private Long id;
        private String name;
        private String city;
        private String country;
    }
}
