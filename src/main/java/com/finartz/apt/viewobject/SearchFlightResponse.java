package com.finartz.apt.viewobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchFlightResponse extends PageResult{

    List<FlightSummary> flightSummaryList;

    @Data
    public static class FlightSummary {
        private Long id;
        private String routeCode;
        private String flightCode;
        private String airlineCompanyCode;
        private int totalSeats;
        private int availableSeats;
        private String duration;
        private String arrivalTime;
        private String departureTime;
        private String arrivalDate;
        private String departureDate;
        private Double seatPrice;
    }
}
