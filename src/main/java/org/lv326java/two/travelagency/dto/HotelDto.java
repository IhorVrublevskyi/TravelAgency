package org.lv326java.two.travelagency.dto;

import java.sql.Date;

public class HotelDto {

    private String country;
    private String city;
    private String hotelName;
    private String hotelAddress;
    private String freeHotelRooms;
    private Date dateCheckin;
    private Date dateCheckout;

    public HotelDto(String country, String city, String hotelName, String hotelAddress, String freeHotelRooms) {
        this.country = country;
        this.city = city;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.freeHotelRooms = freeHotelRooms;
    }

    // setters

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setFreeHotelRooms(String freeHotelRooms) {
        this.freeHotelRooms = freeHotelRooms;
    }

    public void setDateCheckin(Date dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public void setDateCheckout(Date dateCheckout) {
        this.dateCheckout = dateCheckout;
    }

    // getters

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getFreeHotelRooms() {
        return freeHotelRooms;
    }

    public Date getDateCheckin() {
        return dateCheckin;
    }

    public Date getDateCheckout() {
        return dateCheckout;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", freeHotelRooms='" + freeHotelRooms + '\'' +
                ", dateCheckin=" + dateCheckin +
                ", dateCheckout=" + dateCheckout +
                '}';
    }
}
