package com.finartz.apt.dto;

import lombok.Data;

@Data
public class ConversionResult {

    Double targetCurrencyAmount;
    String transactionUUID;

}
