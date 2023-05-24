package com.doganay.springboot_hibernate_countries.service;

import com.doganay.springboot_hibernate_countries.entities.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CountriesRepositoryImpl{

    @Autowired
    private CountryRepository countryRepository;
    private final CountryFileReader countryFileReader;
    @PersistenceContext //Dependency Injection ile projeye dahil edilmesini sağlar.
    private EntityManager entityManager;
    //Nesneler üzerindeki kalıcılık (persistence) işlemlerini yöneten arayüzdür
    public CountriesRepositoryImpl(CountryFileReader countryFileReader) {
        this.countryFileReader = countryFileReader;
    }


    public void insertCountries()  {
        Map<String, Country> countryMap = countryFileReader.readCountriesFromFile();

        for (Map.Entry<String, Country> entry : countryMap.entrySet()) {
            Country country = entry.getValue();
            String countryCode = entry.getKey(); // ülke kodu alınmakta.
            country.setCountryCode(countryCode); //Country sınıfının countryCode özelliğine atanmakta.
            country.setPhone(Integer.parseInt(String.valueOf(country.getPhone())));
            // Languages özelliğini tutmak null olmadan
            String languagesString = String.join(",", country.getLanguages());
            country.setLanguageString(languagesString);
            countryRepository.save(country);
        }

        System.out.println("Veri kaydedildi.");
    }


    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public Country getCountryId(String countryCode) {
        return countryRepository.findBycountryCode(countryCode);
    }

    public void deleteByCountryCode(String countryCode) {
        countryRepository.deleteByCountryCode(countryCode);
    }

    public Country getCountryByPhoneCode(int phone) {
        return countryRepository.findByPhone(phone);
    }

    public List<Country> orderCountriesByPhone(String order) {
        if (order.equals("asc")) {
            return countryRepository.findAllByOrderByPhoneAsc();
        } else if (order.equals("desc")) {
            return countryRepository.findAllByOrderByPhoneDesc();
        } else {
            // Belirtilen sıralama yönü geçersizse tüm ülkeleri döndürür
            return countryRepository.findAll();
        }
    }
    public List<Country> filter(String currency,int phone, String continent) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);

        List<Predicate> predicates = new ArrayList<>();
        if (currency != null && !currency.isEmpty()) {
            predicates.add(builder.equal(root.get("currency"), currency));
        }
        if (phone !=0) {
            predicates.add(builder.equal(root.get("phone"), phone));
        }
        if (continent != null && !continent.isEmpty()) {
            predicates.add(builder.equal(root.get("continent"), continent));
        }

        query.select(root).where(predicates.toArray(new Predicate[]{}));
        //tüm predicate'leri bir diziye dönüştürür
        TypedQuery<Country> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

}