package com.finartz.apt.viewobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchRouteResponse extends PageResult{

    List<RouteSummary> routeSummaryList;

    @Data
    public static class RouteSummary {
        private Long id;
        private String routeCode;
        private String originAirportName;
        private String destinationAirportName;
    }
}
