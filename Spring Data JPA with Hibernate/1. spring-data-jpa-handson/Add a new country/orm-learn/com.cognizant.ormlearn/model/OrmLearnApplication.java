package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testAddCountry();
    }

    private static void testAddCountry() {

        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("XX");
        country.setName("Test Country");

        countryService.addCountry(country);

        try {

            Country newCountry = countryService.findCountryByCode("XX");

            LOGGER.debug("Country : {}", newCountry);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");
    }
}
