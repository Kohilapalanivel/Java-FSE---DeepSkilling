package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        List<Country> countryList = countryService.getAllCountries();

        LOGGER.info("END");

        return countryList;
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {

        LOGGER.info("START");

        LOGGER.info("Country : {}", country);

        // Create Validator Factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Validate Country bean
        Set<ConstraintViolation<Country>> violations = validator.validate(country);

        List<String> errors = new ArrayList<>();

        // Collect validation errors
        for (ConstraintViolation<Country> violation : violations) {
            errors.add(violation.getMessage());
        }

        // Throw exception if validation fails
        if (violations.size() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }

        return country;
    }
}
