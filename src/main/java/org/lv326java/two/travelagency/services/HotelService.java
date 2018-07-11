package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.*;
import org.lv326java.two.travelagency.dto.HotelDto;
import org.lv326java.two.travelagency.entities.*;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class HotelService {

    private HotelDao hotelDao;
    private BookingDao bookingDao;
    private CityDao cityDao;
    private CountryDao countryDao;
    private RoomDao roomDao;

    public HotelService(HotelDao hotelDao, CityDao cityDao, CountryDao countryDao, RoomDao roomDao, BookingDao bookingDao) {
        this.hotelDao = hotelDao;
        this.cityDao = cityDao;
        this.countryDao = countryDao;
        this.roomDao = roomDao;
        this.bookingDao = bookingDao;
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

    public List<HotelDto> searchHotels(Date startDate, Date endDate, String cityName) {
        List<HotelDto> hotelDtos = new LinkedList<>();
        for (Room room : roomDao.getFreeRoomsByPerion(startDate, endDate)) {
            Hotel hotel = hotelDao.getById(room.getHotelId());
//            City hotelCity = cityDao.getById(hotel.getId());
            City ourCity = cityDao.getByFieldName("name", cityName).get(0);

            if (hotel.getCityId().equals(ourCity.getId())) {
                hotelDtos.add(new HotelDto(
                        countryDao.getById(ourCity.getCountryId()).getName(),
                        ourCity.getName(),
                        hotel.getName(),
                        hotel.getAddress(),
                        null
                ));
            }
        }
        return hotelDtos;
    }

    //CRUD

    public boolean insertHotel(Hotel hotel){
        return hotelDao.insert(hotel);
    }

    public boolean deleteHotel(Hotel hotel){
        return hotelDao.delete(hotel);
    }

    public boolean deleteHotelById(Long id){
        return hotelDao.deleteById(id);
    }

}
