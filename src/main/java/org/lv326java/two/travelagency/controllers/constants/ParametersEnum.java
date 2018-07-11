package org.lv326java.two.travelagency.controllers.constants;

public enum ParametersEnum {

    LOGIN_DTO("loginDto"),
    USER_VISAS("userVisas"),
    COUNTRY_ID("countryId"),
    COUNTRY_NAME("countryName"),
    COUNTRY_DTO_LIST("countries"),
    ACTION("action"),
    ENTRY_DATE("entryDate"),
    OUT_DATE("outDate"),
    HOTEL_DTO_LIST("hotels"),
    CITY_NAME("cityName"),
    CITY_DTO_LIST("cities"),
    ERROR("error"),
    SESSION_COOCKIE_NAME("id_session"),
    LOGIN("login"),
    PASSWORD("password"),
    RETYPE_PASSWORD("retypePassword"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    CURRENT_COUNTRY("currentCountry");

    private String url;

    private ParametersEnum(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
