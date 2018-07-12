package org.lv326java.two.travelagency.services;


import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.Role;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.exceptions.PasswordMismatchException;
import org.lv326java.two.travelagency.exceptions.UserAlreadyExistsException;

import java.util.LinkedList;
import java.util.List;

public class UserService {


    private UserDao userDao;
    private RoleDao roleDao;

	public UserService() {
		userDao = new UserDao();
		roleDao = new RoleDao();
	}

    public UserService(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

    public boolean setUserDto(UserDto userDto) {
        boolean result = true;
        User user = userDao.getUserEntityByLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
       // try {
            user.setRoleId(Long.parseLong(userDto.getRole()));
            userDao.updateByEntity(user);
        //} catch (Exception e) {
            // Logging Exception
           // System.out.println("RuntimeException, message: " + e.getMessage());
            //result = false;
       // }
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

    public boolean isValidCredentials(LoginDto loginDto) {
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

    //CRUD

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new LinkedList<>();
        for (User user: userDao.getAll()) {
            Role role = roleDao.getById(user.getRoleId());
            UserDto userDto = new UserDto(
                    user.getLogin(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getLastName(),
                    role.getName());
            userDto.setId(user.getId().toString());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public boolean insertUser(User user){
        return userDao.insert(user);
    }

    public boolean deleteUser(User user){
        return userDao.delete(user);
    }

    public boolean deleteUseryById(Long id){
        return userDao.deleteById(id);
    }

    public UserDto getUserDtoById(Long id) {
	    User user = userDao.getById(id);
	    return new UserDto(
	            user.getLogin(),
                null,
                user.getFirstName(),
                user.getLastName(),
                user.getRoleId().toString()
        );
    }

    public boolean updateUser(UserDto userDto) {
	    User user = userDao.getUserEntityByLogin(userDto.getLogin());
        userDto.setPassword(user.getPassword());
        user.setLogin(user.getLogin());
	    return setUserDto(userDto);
    }
}
