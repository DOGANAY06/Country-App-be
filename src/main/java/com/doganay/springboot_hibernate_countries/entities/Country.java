package com.doganay.springboot_hibernate_countries.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;

import java.beans.ConstructorProperties;
import java.util.Collections;
import java.util.List;

@Table(name="country")
@Entity
@Getter
@Setter
public class Country {

    @Id
    @Column(name ="countryCode")
    private String countryCode;

    private String name;

    @Column(name="native")
    private String nativeName;

    private int phone;

    private String continent;

    private String capital;

    private String currency;


    private String flag;


    private List<String> languages;

    // Getters and setters
    @ConstructorProperties({"countryCode","name", "native", "phone", "continent", "capital", "currency","flag", "languages"})
    public Country(String countryCode, String name, String nativeName, int phone, String continent, String capital, String currency, String flag ,List<String> languages) {
        this.countryCode =countryCode;
        this.name = name;
        this.nativeName =  nativeName;
        this.phone = phone;
        this.continent = continent;
        this.capital = capital;
        this.currency = currency;
        this.flag =flag;
        this.languages = languages != null ? languages : Collections.emptyList();
        //boş olup olmadığını kontrol ettik boşsa boş liste dönecek
    }


    public Country() {

    }

    public void setLanguageString(String languagesString) {

    }
}
