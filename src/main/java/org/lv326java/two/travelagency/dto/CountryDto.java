package org.lv326java.two.travelagency.dto;

public class CountryDto {

    private String id;
    private String name;

    public CountryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    // getters


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
