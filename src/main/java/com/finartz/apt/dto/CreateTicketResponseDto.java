package com.finartz.apt.dto;

import lombok.Data;

@Data
public class CreateTicketResponseDto {
    private Long ticketId;
    private Long ticketNumber;
    private String status;
    private String amount;
}
