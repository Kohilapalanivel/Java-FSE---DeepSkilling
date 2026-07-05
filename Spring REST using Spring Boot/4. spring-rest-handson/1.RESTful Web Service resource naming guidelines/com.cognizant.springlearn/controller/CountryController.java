package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START");
        ArrayList<Country> countryList = countryService.getAllCountries();
        LOGGER.info("END");
        return countryList;
    }
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Country Added");
        return country;
    }
    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        LOGGER.info("Country Updated");
        return country;
    }
    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code) {
        LOGGER.info("Country Deleted : {}", code);
        return "Country Deleted Successfully";
    }
}
