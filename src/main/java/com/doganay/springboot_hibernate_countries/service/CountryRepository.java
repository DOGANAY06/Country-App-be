package com.doganay.springboot_hibernate_countries.service;

import com.doganay.springboot_hibernate_countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    //JPA Repository

    List<Country> findAllByOrderByPhoneAsc();  // Telefon koduna göre artan şekilde sıralı liste döndürür
    List<Country> findAllByOrderByPhoneDesc(); // Telefon koduna göre azalan şekilde sıralı liste döndürür

    Country findByName(String name);

    Country findByPhone(int phone);

    Country findBycountryCode(String countryCode);

    void deleteByCountryCode(String countryCode);
}