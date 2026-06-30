package com.cognizant.ormlearn.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String>
{
    Country findByCode(String code);
    List<Country> findByNameContainingIgnoreCase(String name);

}
