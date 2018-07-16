package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.*;
import org.lv326java.two.travelagency.dto.BookingDto;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.dto.RoomDto;
import org.lv326java.two.travelagency.dto.RoomStatisticsDto;
import org.lv326java.two.travelagency.entities.*;
import org.lv326java.two.travelagency.exceptions.InvalidDateException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class BookingService {

    private BookingDao bookingDao;
    private CountryDao countryDao;
    private CityDao cityDao;
    private HotelDao hotelDao;
    private RoomDao roomDao;
    private VisaDao visaDao;

    public BookingService(BookingDao bookingDao, CountryDao countryDao, CityDao cityDao, HotelDao hotelDao,
                          RoomDao roomDao, VisaDao visaDao) {
        this.bookingDao = bookingDao;
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.hotelDao = hotelDao;
        this.roomDao = roomDao;
        this.visaDao = visaDao;
    }

    public List<BookingDto> searchHotels(String startDate, String endDate, Long cityId, Long userId, boolean onlyAvailable)
            throws InvalidDateException {
        Date checkin = Date.valueOf(startDate);
        Date checkout = Date.valueOf(endDate);
        checkDate(checkin, checkout);
        List<BookingDto> bookingDtos = new LinkedList<>();
        List<Room> rooms = roomDao.getFreeRoomsByPeriod(Date.valueOf(startDate), Date.valueOf(endDate));
        Map<Long, List<Room>> map = new HashMap<>();
        List<Long> availableCountryIds = new LinkedList<>();
        if (onlyAvailable) {
            for (Visa visa : visaDao.getByUserId(userId)) {
                availableCountryIds.add(visa.getCountryId());
            }
        }
        City ourCity = cityDao.getById(cityId);
        for (Room room : rooms) {
            if (map.containsKey(room.getHotelId())) {
                map.get(room.getHotelId()).add(room);
            } else {
                List<Room> hotelRoomList = new LinkedList<>();
                hotelRoomList.add(room);
                map.put(room.getHotelId(), hotelRoomList);
            }
        }
        for (Long hotelId : map.keySet()) {
            Hotel hotel = hotelDao.getById(hotelId);
            if (hotel.getCityId().equals(ourCity.getId()) &&
                    (!onlyAvailable || availableCountryIds.contains(ourCity.getCountryId()))) {
                BookingDto bookingDto = new BookingDto(
                        hotel.getId().toString(),
                        hotel.getName(),
                        hotel.getAddress(),
                        countryDao.getById(ourCity.getCountryId()).getName(),
                        ourCity.getName(),
                        startDate,
                        endDate
                );
                List<RoomDto> availableRoomDtos = new LinkedList<>();
                for (Room room : map.get(hotelId)) {
                    availableRoomDtos.add(new RoomDto(room.getId().toString(), room.getRoomNumber().toString()));
                }
                bookingDto.setAvailableRooms(availableRoomDtos);
                bookingDto.setUserId(userId.toString());
                bookingDtos.add(bookingDto);
            }
        }
        return bookingDtos;
    }

    public boolean addBooking(BookingDto bookingDto) {
        return bookingDao.insert(new Booking(
                0L,
                Long.parseLong(bookingDto.getUserId()),
                Long.parseLong(bookingDto.getRoomId()),
                Date.valueOf(bookingDto.getDateCheckin()),
                Date.valueOf(bookingDto.getDateCheckout())
        ));
    }

    public List<CountryDto> getVisitedCountriesByUserId(Long userId) {
        Set<Long> countryIds = new HashSet<>();
        List<CountryDto> visitedCountries = new LinkedList<>();
        for(Booking booking : bookingDao.getByUserId(userId)) {
            countryIds.add(cityDao.getById(hotelDao.getById(roomDao.getById(booking.getRoomId()).getHotelId())
                    .getCityId()).getCountryId());
        }
        for (Long countryId : countryIds) {
            Country country = countryDao.getById(countryId);
            visitedCountries.add(new CountryDto(
                    country.getId().toString(),
                    country.getName()
            ));
        }
        return visitedCountries;
    }

    public List<RoomStatisticsDto> getRoomLoadStats(Date startDate, Date endDate) {
        List<RoomStatisticsDto> resultList = new LinkedList<>();
        Map<Long, Integer> roomLoad = bookingDao.roomLoad(startDate, endDate);

        for(Long roomId : roomLoad.keySet()) {
            Room room = roomDao.getById(roomId);
            Hotel hotel = hotelDao.getById(room.getHotelId());
            resultList.add(new RoomStatisticsDto(
                    hotel.getName(),
                    room.getRoomNumber().toString(),
                    roomLoad.get(roomId).toString()
            ));
        }

        return resultList;
    }

    private void checkDate(Date checkin, Date checkout) throws InvalidDateException {
        if ((checkin.getTime() - checkout.getTime() > 0) ||
                (checkin.getTime() - Date.valueOf(LocalDate.now()).getTime() < 0) ||
                (checkin.getTime() == checkout.getTime())) {
            throw new InvalidDateException("Date is invalid");
        }
    }
}
