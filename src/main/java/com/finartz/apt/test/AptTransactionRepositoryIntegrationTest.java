package com.finartz.apt.test;

import com.finartz.apt.repository.AirlineCompanyRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AptTransactionRepositoryIntegrationTest {

    @Autowired
    private final AirlineCompanyRepository airlineCompanyRepository;

    public AptTransactionRepositoryIntegrationTest(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    // test cases can be written in here
}