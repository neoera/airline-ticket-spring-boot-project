package com.finartz.apt.viewobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Data
public class SearchTicketResponse{
    private Long id;
    private PassengerDto passengerDto;
    private Long number;
    private String paymentDate;
    private String paymentAmount;
    private String flightCode;
    private String status;
    private int seatNumber;
}
