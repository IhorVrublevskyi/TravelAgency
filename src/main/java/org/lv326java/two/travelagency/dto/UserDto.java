package org.lv326java.two.travelagency.dto;

public class UserDto {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

	public UserDto(String login, String password, String firstName, String lastName, String role) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	// setters

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
