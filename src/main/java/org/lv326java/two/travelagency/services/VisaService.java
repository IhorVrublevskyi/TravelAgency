package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.UserDao;

public class VisaService {

    private CountryDao countryDao;
    private UserDao userDao;

    public VisaService() {
        this.countryDao = new CountryDao();
        this.userDao = new UserDao();
    }

    public VisaService(CountryDao countryDao, UserDao userDao) {
        this.countryDao = countryDao;
        this.userDao = userDao;
    }

    public Long getIdUserByLogin(String login) {
        return userDao.getUserEntityByLogin(login).getId();
    }

    public Long getIdCountryByName(String name) {
        return countryDao.getByFieldName("name", name).get(0).getId();
    }
}
