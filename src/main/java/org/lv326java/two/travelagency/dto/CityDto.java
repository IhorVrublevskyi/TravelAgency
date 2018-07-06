package org.lv326java.two.travelagency.dto;

public class CityDto {

    private String id;
    private String name;
    private String countryId;

    public CityDto(String id, String name, String countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    // getters


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryId() {
        return countryId;
    }
}
