package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CityDao;
import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.HotelDao;
import org.lv326java.two.travelagency.dao.RoomDao;
import org.lv326java.two.travelagency.dto.HotelDto;
import org.lv326java.two.travelagency.entities.City;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.Hotel;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class HotelService {

    private HotelDao hotelDao;
    private CityDao cityDao;
    private CountryDao countryDao;
    private RoomDao roomDao;

    public HotelService(HotelDao hotelDao, CityDao cityDao, CountryDao countryDao, RoomDao roomDao) {
        this.hotelDao = hotelDao;
        this.cityDao = cityDao;
        this.countryDao = countryDao;
        this.roomDao = roomDao;
    }

    //TODO rewrite this method
    public List<HotelDto> getAllHotels() {
        List<HotelDto> hotelDtos = new LinkedList<>();

        for (Hotel hotel : hotelDao.getAll()) {
            City city = cityDao.getById(hotel.getCityId());
            Country country = countryDao.getById(city.getCountryId());

//            TODO Refactor rooms system
            int roomCount = roomDao.getByFieldName("hotel_id", hotel.getId().toString()).size();
            HotelDto hotelDto = new HotelDto(
                    country.getName(),
                    city.getName(),
                    hotel.getName(),
                    hotel.getAddress(),
                    Integer.toString(roomCount));
            hotelDto.setId(hotel.getId().toString());
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }


}
