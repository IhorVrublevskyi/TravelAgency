package org.lv326java.two.travelagency.services;


import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.entities.Visa;
import org.lv326java.two.travelagency.exceptions.PasswordMismatchException;
import org.lv326java.two.travelagency.exceptions.UserAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public class UserService {


    private UserDao userDao;
    private RoleDao roleDao;
    private VisaDao visaDao;
    private CountryDao countryDao;



//    private UserService() {
//    }

//    private static UserService instance;
//
//    public static UserService getInstance() {
//        if (instance == null) {
//            instance = new UserService();
//        }
//        return instance;
//    }


	public UserService() {
		userDao = new UserDao();
		roleDao = new RoleDao();
		visaDao = new VisaDao();
        countryDao = new CountryDao();
	}

	private UserService(UserDao userDao, RoleDao roleDao, VisaDao visaDao, CountryDao countryDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.visaDao = visaDao;
		this.countryDao = countryDao;
	}

    public boolean setUserDto(UserDto userDto) {
        boolean result = true;
        User user = userDao.getUserEntityByLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        try {
            user.setRoleId(roleDao.getRoleEntityByName(userDto.getRole()).getId());
            userDao.updateByEntity(user);
        } catch (Exception e) {
            // Logging Exception
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public UserDto getUserDto(LoginDto loginDto) {
        User user = userDao.getUserEntityByLogin(loginDto.getLogin());
        return new UserDto(user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                roleDao.getById(user.getRoleId()).getName());
    }

    public Long getRoleDao(LoginDto loginDto) {
        User user = null;
        user = userDao.getUserEntityByLogin(loginDto.getLogin());
        return user.getRoleId();
    }

    public Long getIdUserByLogin(LoginDto loginDto) {
        return userDao.getUserEntityByLogin(loginDto.getLogin()).getId();
    }

    public Long getIdUserByLogin(UserDto userDto) {
        return userDao.getUserEntityByLogin(userDto.getLogin()).getId();
    }

    public boolean isValid(LoginDto loginDto) {
        boolean result = true;
        User user = null;
        try {
            user = userDao.getUserEntityByLogin(loginDto.getLogin());
        } catch (Exception e) {
            // Logging Exception
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        result = result && (user.getPassword().equals(loginDto.getPassword()));
        return result;
    }

    // TODO Fix this method
    public boolean isExist(RegistrationDto registrationDto) {
        try {
            userDao.getUserEntityByLogin(registrationDto.getLogin());
        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
            return false;
        }
        return true;
	}

	// TODO Create password error and user exists error exceptions
	public void createNewUser(RegistrationDto registrationDto) throws PasswordMismatchException,
            UserAlreadyExistsException {
	    if (!registrationDto.getPassword().equals(registrationDto.getRetypePassword())) {
	        throw new PasswordMismatchException("Passwords didn't match");
        }
        if (isExist(registrationDto)) {
	        throw new UserAlreadyExistsException("User with login '" + registrationDto.getLogin() + "' already exists");
        }
	    User user = new User(
	            null,
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getLogin(),
                registrationDto.getPassword(),
                1L);
	    userDao.insert(user);
    }
}
