package org.lv326java.two.travelagency;

import org.lv326java.two.travelagency.dao.UserDao;

public class App {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getUserEntityByLogin("masha123"));
    }
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
}
