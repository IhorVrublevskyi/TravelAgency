package org.lv326java.two.travelagency;

import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.entities.User;

public class App {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User user = userDao.getByFieldName("roles_id", "2").get(0);
        System.out.println(user);
        UserDto userDto = new UserDto(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(),
                user.getRoleId().toString());


    }
}
