package org.lv326java.two.travelagency.dto;

public class CityDto {

    private String id;
    private String name;
    private String country;

    public CityDto(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    // setters


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // getters


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
