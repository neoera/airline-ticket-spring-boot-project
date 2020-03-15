package com.finartz.apt.viewobject;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    long getTotalElements; // number of total elements in the table
    int totalPages; // number of total pages in the table
}
