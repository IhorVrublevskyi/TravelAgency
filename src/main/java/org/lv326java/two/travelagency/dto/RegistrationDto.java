package org.lv326java.two.travelagency.dto;

public class RegistrationDto {

    private String login;
    private String password;
    private String firstNmae;
    private String lastName;

    public RegistrationDto(String login, String password, String firstNmae, String lastName) {
        this.login = login;
        this.password = password;
        this.firstNmae = firstNmae;
        this.lastName = lastName;
    }

    // setters

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getters

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstNmae='" + firstNmae + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
