package org.lv326java.two.travelagency.dto;

public class RoomStatisticsDto {
    private String hotelName;
    private String roomNumber;
    private String roomLoad;

    public RoomStatisticsDto(String hotelName, String roomNumber, String roomLoad) {
        this.hotelName = hotelName;
        this.roomNumber = roomNumber;
        this.roomLoad = roomLoad;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomLoad() {
        return roomLoad;
    }
}
