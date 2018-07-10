package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.dto.HotelDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.Hotel;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<CountryDto> getAllCountries(){
        List<CountryDto> countryDtos = new LinkedList<>();
        for (Country country: countryDao.getAll()) {
            CountryDto countryDto = new CountryDto(
                    String.valueOf(country.getId()),
                    country.getName()
            );
            countryDtos.add(countryDto);
        }

        return countryDtos;
    }

    public boolean insertCountry(Country country){
        return countryDao.insert(country);
    }

    public boolean deleteCountry(Country country){
        return countryDao.delete(country);
    }

    public boolean deleteCountryById(Long id){
        return countryDao.deleteById(id);
    }

    public static void main(String[] args) {
        CountryService countryService = new CountryService();
        List<CountryDto> countryDtos = new ArrayList<>();
        System.out.println(countryDtos = countryService.getAllCountries());

    }
}