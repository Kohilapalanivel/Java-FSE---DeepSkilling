package com.cognizant.ormlearn.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String>
{
    // Find country by code
    Country findByCode(String code);
    // Find countries by partial name
    List<Country> findByNameContainingIgnoreCase(String name);

}
