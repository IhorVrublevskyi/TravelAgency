package org.lv326java.two.travelagency.dto;

public class VisaDto {

    private String country;
    private String user;
    private String dateOfInit;
    private String dateOfExpired;

    public VisaDto(String country, String user, String dateOfInit, String dateOfExpired) {
        this.country = country;
        this.user = user;
        this.dateOfInit = dateOfInit;
        this.dateOfExpired = dateOfExpired;
    }

    // setters

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDateOfInit(String dateOfInit) {
        this.dateOfInit = dateOfInit;
    }

    public void setDateOfExpired(String dateOfExpired) {
        this.dateOfExpired = dateOfExpired;
    }


    // getters


    public String getCountry() {
        return country;
    }

    public String getUser() {
        return user;
    }

    public String getDateOfInit() {
        return dateOfInit;
    }

    public String getDateOfExpired() {
        return dateOfExpired;
    }

    @Override
    public String toString() {
        return "VisaDto{" +
                "country='" + country + '\'' +
                ", user='" + user + '\'' +
                ", dateOfInit=" + dateOfInit +
                ", dateOfExpired=" + dateOfExpired +
                '}';
    }
}
