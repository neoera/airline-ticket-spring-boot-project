package com.finartz.apt.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateFlightRequestDto {
    private String flightCode;
    private String routeCode;
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
