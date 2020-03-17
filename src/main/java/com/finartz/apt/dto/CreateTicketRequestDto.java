package com.finartz.apt.dto;

import com.finartz.apt.viewobject.PassengerDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateTicketRequestDto {
    private String flightCode;
    private String country;
    private PassengerDto passengerDto;
}
