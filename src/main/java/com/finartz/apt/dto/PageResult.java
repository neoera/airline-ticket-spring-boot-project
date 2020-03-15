package com.finartz.apt.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {

    long getTotalElements; // number of total elements in the table
    int totalPages; // number of total pages in the table
    List<ConversionResult> conversionResults;

}
