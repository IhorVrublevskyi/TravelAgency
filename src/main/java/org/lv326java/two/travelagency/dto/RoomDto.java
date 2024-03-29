package org.lv326java.two.travelagency.dto;

public class RoomDto {
    private String id;
    private String number;
    private String hotelId;

    public RoomDto(String id, String number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelId() {
        return hotelId;
    }
}
