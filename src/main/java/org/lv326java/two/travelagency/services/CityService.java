package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CityDao;
import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dto.CityDto;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.entities.City;
import org.lv326java.two.travelagency.entities.Country;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CityService {

    private CityDao cityDao;
    private CountryDao countryDao;

    public CityService(CityDao cityDao, CountryDao countryDao) {
        this.cityDao = cityDao;
        this.countryDao = countryDao;
    }


    public CityService() {
        this.cityDao = new CityDao();
        this.countryDao = new CountryDao();
    }

    //CRUD

    public List<CityDto> getAllCitiesDto() {
        List<City> cities;
        List<CityDto> result = new LinkedList<>();
        cities = cityDao.getAll();
        for (City city : cities) {
            result.add(new CityDto(city.getId().toString(), city.getName(), countryDao.getById(city.getCountryId()).getName()));
        }
        return result;
    }

    public boolean insertCity(CityDto cityDto){
        return cityDao.insert(new City(Long.parseLong(cityDto.getId()), cityDto.getName(), Long.parseLong(cityDto.getCountry())));
    }

    public boolean deleteCity(CityDto cityDto){
        return cityDao.delete(new City(Long.parseLong(cityDto.getId()), cityDto.getName(), Long.parseLong(cityDto.getCountry())));
    }

    public boolean deleteCityById(Long id){
        return cityDao.deleteById(id);
    }

    public CityDto getCityDtoById(Long id) {
        City city = cityDao.getById(id);
        return new CityDto(
                city.getId().toString(),
                city.getName(),
                countryDao.getById(city.getCountryId()).getName()
        );
    }

    public boolean updateCity(CityDto cityDto) {

        return cityDao.updateByEntity(new City(
                Long.parseLong(cityDto.getId()),
                cityDto.getName(),
                Long.parseLong(cityDto.getCountry())
        ));
    }
}