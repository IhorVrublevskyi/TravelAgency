package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.dto.VisaDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.entities.Visa;

import java.sql.Date;
import java.util.LinkedList;
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

    public List<VisaDto> getVisaByUserLogin(String login) {
        User user;
        List<Visa> visas;
        List<VisaDto> result = new LinkedList<>();
        try {
            user = userDao.getUserEntityByLogin(login);
            visas = visaDao.getByFieldName("user_id", user.getId().toString());

            for (Visa visa : visas) {
                result.add(new VisaDto(countryDao.getById(visa.getCountryId()).getName(), null,
                        visa.getDateOfInit().toString(), visa.getDateOfExpired().toString()));
            }

        } catch (Exception e) {
            System.out.println("RuntimeException, message: " + e.getMessage());
        }
        return result;
    }

    public boolean addVisa(VisaDto visaDto) {
        return visaDao.insert(new Visa(
                null,
                Long.parseLong(visaDto.getCountry()),
                Long.parseLong(visaDto.getUser()),
                Date.valueOf(visaDto.getDateOfInit()),
                Date.valueOf(visaDto.getDateOfExpired())));
    }
}
