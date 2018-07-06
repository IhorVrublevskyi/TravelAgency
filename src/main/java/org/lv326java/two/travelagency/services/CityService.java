package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CityDao;
import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dto.CityDto;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.entities.City;
import org.lv326java.two.travelagency.entities.Country;

import java.util.ArrayList;
import java.util.List;

public class CityService {

    private CityDao cityDao;

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public CityService() {
        this.cityDao = new CityDao();
    }

    public List<CityDto> getAllCitiesDto() {
        List<City> cities;
        List<CityDto> result = new ArrayList<>();
        cities = cityDao.getAll();
        for (City city: cities) {
            result.add(new CityDto(null, city.getName(), null));
        }
        return result;
    }
}