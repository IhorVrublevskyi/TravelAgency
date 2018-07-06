package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.entities.Visa;

import java.util.List;

public class VisaService {

    private CountryDao countryDao;
    private UserDao userDao;
    private VisaDao visaDao;

    public VisaService() {
        this.countryDao = new CountryDao();
        this.userDao = new UserDao();
        this.visaDao = new VisaDao();
    }

    public VisaService(CountryDao countryDao, UserDao userDao, VisaDao visaDao) {
        this.countryDao = countryDao;
        this.userDao = userDao;
        this.visaDao = visaDao;
    }

    public Long getIdUserByLogin(String login) {
        return userDao.getUserEntityByLogin(login).getId();
    }

    public Long getIdCountryByName(String name) {
        return countryDao.getByFieldName("name", name).get(0).getId();
    }

    public List<Visa> getVisaByUserLogin(String login) {
        User user = null;
        List<Visa> visas = null;
        try {
            user = userDao.getUserEntityByLogin(login);
            visas = visaDao.getByFieldName("user_id", user.getId().toString());

        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
        }
        return visas;
    }

    public String getCountryById(Long id) {
        Country country = null;
        country = countryDao.getById(id);
        try {
            country = countryDao.getById(id);
        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
        }
        return country.getName();
    }

}
