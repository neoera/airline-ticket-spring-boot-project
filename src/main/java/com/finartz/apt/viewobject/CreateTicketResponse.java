package com.finartz.apt.viewobject;

import lombok.Data;

@Data
public class CreateTicketResponse {
    private Long ticketId;
    private String ticketNumber;
    private String status;
    private String amount;
}
