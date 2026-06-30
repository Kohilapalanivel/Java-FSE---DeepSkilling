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
public class OrmLearnApplication 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) 
    {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
        countryService = context.getBean(CountryService.class);
        testGetCountry();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testSearchCountry();
     }
    private static void testGetCountry() 
    {
        LOGGER.info("Start");
        Country country = countryService.getCountry("IN");
        LOGGER.debug("Country : {}", country);
        LOGGER.info("End");
    }
    private static void testAddCountry() 
    {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("XX");
        country.setName("Test Country");
        countryService.addCountry(country);
        LOGGER.debug("Country Added Successfully");
        LOGGER.info("End");
    }
    private static void testUpdateCountry() 
    {
        LOGGER.info("Start");
        Country country = countryService.getCountry("XX");
        country.setName("Updated Test Country");
        countryService.updateCountry(country);
        LOGGER.debug("Country Updated Successfully");
        LOGGER.info("End");
    }
    private static void testDeleteCountry() 
    {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        LOGGER.debug("Country Deleted Successfully");
        LOGGER.info("End");
    }
    private static void testSearchCountry()
    {
        LOGGER.info("Start");
        List<Country> countries = countryService.findByNameContaining("ou");
        LOGGER.debug("Countries : {}", countries);
        LOGGER.info("End");
    }   
}
