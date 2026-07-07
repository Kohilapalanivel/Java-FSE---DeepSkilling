package com.cognizant.springlearn.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/countries")
public class CountryController 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    @Autowired
    private CountryService countryService;
    @GetMapping
    public List<Country> getAllCountries() 
    {
        LOGGER.info("START");
        List<Country> countryList = countryService.getAllCountries();
        LOGGER.info("END");
        return countryList;
    }
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) 
    {
        LOGGER.info("START");
        LOGGER.info("Country : {}", country);
        return country;
    }
}
