package org.lv326java.two.travelagency.dto;

public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String retypePassword;

    public RegistrationDto(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    //constructor for retype checking
    public RegistrationDto(String firstName, String lastName, String login, String password, String retypePassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.retypePassword = retypePassword;
    }

    // setters

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    // getters

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstNmae='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
