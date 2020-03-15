package com.finartz.apt.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateAirportRequestDto {
    private String name;
    private String city;
    private String country;
}
