package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.entities.Country;

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
            result.add(new CountryDto(country.getId().toString(), country.getName()));
        }
        return result;
    }

    //CRUD

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

    public boolean insertCountry(CountryDto countryDto){
        return countryDao.insert(new Country(Long.parseLong(countryDto.getId()), countryDto.getName()));
    }

    public boolean deleteCountryById(Long id){
        return countryDao.deleteById(id);
    }

    public boolean updateContry(CountryDto countryDto) {
        return countryDao.updateByEntity(new Country(
                Long.parseLong(countryDto.getId()),
                countryDto.getName()
        ));
    }

    public CountryDto getCountryDtoById(Long id) {
        Country country = countryDao.getById(id);
        return new CountryDto(
                country.getId().toString(),
                country.getName()
        );
    }
}