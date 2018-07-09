package org.lv326java.two.travelagency.dto;

public class CityDto {

    private String name;
    private String country;

    public CityDto(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
