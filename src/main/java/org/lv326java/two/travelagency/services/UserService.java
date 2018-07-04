package org.lv326java.two.travelagency.services;


import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.User;

public class UserService {


    private UserDao userDao;
    private RoleDao roleDao;

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
	}

	private UserService(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
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

}
