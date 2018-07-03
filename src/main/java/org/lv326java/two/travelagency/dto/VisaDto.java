package org.lv326java.two.travelagency.dto;

import java.sql.Date;

public class VisaDto {

    private String country;
    private String user;
    private Date dateOfInit;
    private Date dateOfCheckOut;

    public VisaDto(String country, String user, Date dateOfInit, Date dateOfCheckOut) {
        this.country = country;
        this.user = user;
        this.dateOfInit = dateOfInit;
        this.dateOfCheckOut = dateOfCheckOut;
    }

    // setters

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDateOfInit(Date dateOfInit) {
        this.dateOfInit = dateOfInit;
    }

    public void setDateOfCheckOut(Date dateOfCheckOut) {
        this.dateOfCheckOut = dateOfCheckOut;
    }


    // getters


    public String getCountry() {
        return country;
    }

    public String getUser() {
        return user;
    }

    public Date getDateOfInit() {
        return dateOfInit;
    }

    public Date getDateOfCheckOut() {
        return dateOfCheckOut;
    }

    @Override
    public String toString() {
        return "VisaDto{" +
                "country='" + country + '\'' +
                ", user='" + user + '\'' +
                ", dateOfInit=" + dateOfInit +
                ", dateOfCheckOut=" + dateOfCheckOut +
                '}';
    }
}
