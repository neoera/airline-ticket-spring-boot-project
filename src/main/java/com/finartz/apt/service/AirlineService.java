package com.finartz.apt.service;

import com.finartz.apt.dto.CreateAirlineRequestDto;
import com.finartz.apt.dto.CreateAirlineResponseDto;
import com.finartz.apt.entity.AirlineCompany;
import com.finartz.apt.repository.AirlineCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirlineService {

    private final AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    public AirlineService(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public CreateAirlineResponseDto createAirline(CreateAirlineRequestDto createAirlineRequestDto) {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setName(createAirlineRequestDto.getName());
        airlineCompanyRepository.save(airlineCompany);

        CreateAirlineResponseDto createAirlineResponseDto = new CreateAirlineResponseDto();
        createAirlineResponseDto.setAirlineCompanyId(airlineCompany.getAirlineCompanyId());
        createAirlineResponseDto.setName(airlineCompany.getName());
        return createAirlineResponseDto;
    }
}
