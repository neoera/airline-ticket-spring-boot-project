package com.finartz.apt.service;

import com.finartz.apt.entity.Airport;
import com.finartz.apt.repository.AirportRepository;
import com.finartz.apt.dto.CreateAirportRequestDto;
import com.finartz.apt.dto.CreateAirportResponseDto;
import com.finartz.apt.viewobject.SearchAirportRequest;
import com.finartz.apt.viewobject.SearchAirportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PassengerService {


}
