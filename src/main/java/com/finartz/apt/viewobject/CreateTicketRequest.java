package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateTicketRequest {
    private String flightCode;
    private String country;
    private Passenger passenger;

    @Data
    public class Passenger{
        private String name;
        private String surname;
        private String address;
        private int telephoneNumber;
        private String email;
        private String dateOfBirth;
    }

}
