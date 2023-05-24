package com.doganay.springboot_hibernate_countries.controller;

import com.doganay.springboot_hibernate_countries.entities.Country;
import com.doganay.springboot_hibernate_countries.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryJpaController {
    @Autowired
    private CountriesRepositoryImpl countriesRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/one-time-insert")
    public ResponseEntity<String> oneTimeInsert()  {
        // Veritabanında herhangi bir ülke kaydı olup olmadığını kontrolü
        if (countryRepository.count() == 0) {
            // Tüm ülkelerin tek seferlik eklemesi
            countriesRepository.insertCountries();
            return ResponseEntity.ok("Ülkeler başarıyla eklendi");
        } else {
            // Ülke kayıtları veritabanında zaten var
            return ResponseEntity.ok("Ülke eklenemedi var zaten.");
        }
    }
    @GetMapping("/all")
    public List<Country> getAllCountries() {  //tüm ülkeleri getirme
        return countriesRepository.getAllCountries();
    }

    @GetMapping("/name/{name}")
    public Country getCountryByName(@PathVariable("name") String name) {
       return countriesRepository.getCountryByName(name);


    }

    @PostMapping("/add") //ürün ekleme işlemi için
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = countriesRepository.saveCountry(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping("/countrycode/{countryCode}")
    public Country getCountryById(@PathVariable("countryCode") String countryCode) { //id dediği ülke kodu
        return countriesRepository.getCountryId(countryCode);
    }


    @GetMapping("/phone/{phone}")
    public Country getCountryByPhoneCode(@PathVariable("phone") int phone) {
        return countriesRepository.getCountryByPhoneCode(phone);
    }
    //ülkeyi veritabanından silmek için
    @DeleteMapping("/countrycode/{countryCode}")
    public ResponseEntity<String> deleteByCountryCode(@PathVariable("countryCode") String countryCode) {
        countriesRepository.deleteByCountryCode(countryCode);
        return ResponseEntity.ok("Ülke silme işlemi tamamlandı");
    }


    @GetMapping("/order")
    public List<Country> orderCountriesByPhone(@RequestParam(required = false, defaultValue = "asc") String order) {
        return countriesRepository.orderCountriesByPhone(order);
    }
    @GetMapping("/filter/{currency}/{phone}/{continent}")
    public List<Country> filterCountries(@PathVariable String currency, @PathVariable int phone, @PathVariable String continent) {
        return countriesRepository.filter(currency,phone,continent);
    }
}
