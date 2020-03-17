package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class PassengerDto {
    private Long identityNumber;
    private String name;
    private String surname;
    private String address;
    private Integer telephoneNumber;
    private String email;
    private String dateOfBirth;
}