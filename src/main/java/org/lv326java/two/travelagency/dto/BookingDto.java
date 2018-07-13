package org.lv326java.two.travelagency.dto;

import java.sql.Date;
import java.util.List;

public class BookingDto {

    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String country;
    private String city;
    private String dateCheckin;
    private String dateCheckout;
    private String userId;
    private String roomId;
    private List<RoomDto> availableRooms;

    public BookingDto(String hotelId, String hotelName, String hotelAddress, String country, String city,
                      String dateCheckin, String dateCheckout) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.country = country;
        this.city = city;
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDateCheckin() {
        return dateCheckin;
    }

    public String getDateCheckout() {
        return dateCheckout;
    }

    public String getUserId() {
        return userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public List<RoomDto> getAvailableRooms() {
        return availableRooms;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setAvailableRooms(List<RoomDto> availableRooms) {
        this.availableRooms = availableRooms;
    }
}
