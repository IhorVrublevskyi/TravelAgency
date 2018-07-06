package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.entities.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    private CountryDao countryDao;

    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public CountryService() {
        this.countryDao = new CountryDao();
    }

    public List<CountryDto> getAllCountriesDto() {
        List<Country> countries;
        List<CountryDto> result = new ArrayList<>();
        countries = countryDao.getAll();
        for (Country country : countries) {
            result.add(new CountryDto(null, country.getName()));
        }
        return result;
    }
}