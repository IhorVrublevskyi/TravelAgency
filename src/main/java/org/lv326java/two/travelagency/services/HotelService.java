package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.*;
import org.lv326java.two.travelagency.dto.HotelDto;
import org.lv326java.two.travelagency.entities.*;

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

    public HotelDto getHotelDtoById(Long id) {
        Hotel hotel = hotelDao.getById(id);
        City city = cityDao.getById(hotel.getCityId());
        HotelDto hotelDto = new HotelDto(
                countryDao.getById(city.getCountryId()).getName(),
                city.getName(),
                hotel.getName(),
                hotel.getAddress());
        hotel.setId(hotel.getId());
        return hotelDto;
    }

    //TODO rewrite this method
    public List<HotelDto> getAllHotelsDto() {
        List<HotelDto> hotelDtos = new LinkedList<>();
        for (Hotel hotel : hotelDao.getAll()) {
            City city = cityDao.getById(hotel.getCityId());
            Country country = countryDao.getById(city.getCountryId());
//            int roomCount = roomDao.getByFieldName("hotel_id", hotel.getId().toString()).size();
            HotelDto hotelDto = new HotelDto(
                    country.getName(),
                    city.getName(),
                    hotel.getName(),
                    hotel.getAddress());
            hotelDto.setId(hotel.getId().toString());
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

    //CRUD

    public boolean insertHotel(HotelDto hotelDto) {
        return hotelDao.insert(new Hotel(
                0L,
                hotelDto.getHotelName(),
                Long.parseLong(hotelDto.getCity()),
                hotelDto.getHotelAddress()
        ));
    }

    public boolean deleteHotel(HotelDto hotelDto) {
        return hotelDao.deleteById(Long.parseLong(hotelDto.getId()));
    }

    public boolean deleteHotelById(Long id) {
        return hotelDao.deleteById(id);
    }

    public boolean updateHotel(HotelDto hotelDto) {

        return hotelDao.updateByEntity(new Hotel(
                Long.parseLong(hotelDto.getId()),
                hotelDto.getHotelName(),
                Long.parseLong(hotelDto.getCity()),
                hotelDto.getHotelAddress()
        ));
    }

}
