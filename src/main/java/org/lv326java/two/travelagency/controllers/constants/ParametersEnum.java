package org.lv326java.two.travelagency.controllers.constants;

public enum ParametersEnum {

    LOGIN_DTO("loginDto"),
    USER_VISAS("userVisas"),
    COUNTRY_ID("countryId"),
    COUNTRY_NAME("countryName"),
    COUNTRY_DTO_LIST("countries"),
    CITY_ID("cityId"),
    CITY_NAME("cityName"),
    CITY_DTO_LIST("cities"),
    HOTEL_ID("hotelId"),
    HOTEL_NAME("hotelName"),
    HOTEL_ADDRESS("hotelAddress"),
    HOTEL_DTO_LIST("hotels"),
    CURRENT_BOOKING("currentBooking"),
    BOOKING_DTO("bookingDto"),
    BOOKING_DTO_LIST("bookings"),
    ACTION("action"),
    ENTRY_DATE("entryDate"),
    OUT_DATE("outDate"),
    ERROR("error"),
    SESSION_COOCKIE_NAME("id_session"),
    LOGIN("login"),
    PASSWORD("password"),
    RETYPE_PASSWORD("retypePassword"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    CURRENT_COUNTRY("currentCountry"),
    CURRENT_CITY("currentCity"),
    CURRENT_HOTEL("currentHotel"),
    CURRENT_USER("currentUser"),
    USER_DTO_LIST("users"),
    ROLE_ID("roleId"),
    ROLE_DTO_LIST("roles"),
    USER_ID("userId"),
    NUMBER_OF_VISAS("numberOfVisas"),
    ROOM_ID("roomId"),
    ONLY_AVAILABLE_COUNTRIES("onlyAvailable");

    private String url;

    ParametersEnum(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
