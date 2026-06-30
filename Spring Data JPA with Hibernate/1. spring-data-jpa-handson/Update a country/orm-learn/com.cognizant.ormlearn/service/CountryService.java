package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country getCountry(String code) {
        return countryRepository.findByCode(code);
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {

        Optional<Country> result = countryRepository.findById(code);

        if (result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country);
        }

    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional
    public List<Country> findByNameContaining(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }

        return result.get();
    }
}
