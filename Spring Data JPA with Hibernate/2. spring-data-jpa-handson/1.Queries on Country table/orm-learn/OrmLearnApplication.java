package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        testSearchCountry();

        //testSearchCountrySorted();

        //testCountriesStartingWith();

    }

    // Query 1
    private static void testSearchCountry() {

        LOGGER.info("Start");

        List<Country> countries = countryService.findCountriesContaining("ou");

        countries.forEach(System.out::println);

        LOGGER.info("End");
    }

    // Query 2
    private static void testSearchCountrySorted() {

        LOGGER.info("Start");

        List<Country> countries = countryService.findCountriesContainingSorted("ou");

        countries.forEach(System.out::println);

        LOGGER.info("End");
    }

    // Query 3
    private static void testCountriesStartingWith() {

        LOGGER.info("Start");

        List<Country> countries = countryService.findCountriesStartingWith("Z");

        countries.forEach(System.out::println);

        LOGGER.info("End");
    }
}
