package com.cognizant.springlearn.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.Country;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class CountryController 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    @SuppressWarnings("unchecked")
    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
        LOGGER.info("END");
        return countryList;
    }
}
