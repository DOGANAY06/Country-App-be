package com.doganay.springboot_hibernate_countries.service;

import com.doganay.springboot_hibernate_countries.entities.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Component //diğer sınıflara otomatik olarak bağlanmasını sağlar
public class CountryFileReader {

    private static final String FILE_PATH = "data/countries.json"; // okunacak dosyanın bulunduğu konu

    public Map<String, Country> readCountriesFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<String, Country>> typeReference = new TypeReference<Map<String, Country>>() {};

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String data = reader.lines().collect(Collectors.joining());
            return objectMapper.readValue(data, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
