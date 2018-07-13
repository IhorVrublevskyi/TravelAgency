package org.lv326java.two.travelagency;

import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.dto.VisaDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.entities.Visa;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        UserDao userDao = new UserDao();
//        User user = userDao.getByFieldName("roles_id", "2").get(0);
//        System.out.println(user);
//        UserDto userDto = new UserDto(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(),
//                user.getRoleId().toString());


        List<Country> countries;
        List<Visa> visas;
        CountryDao countryDao = new CountryDao();
        VisaDao visaDao = new VisaDao();
        List<VisaDto> result = new LinkedList<>();
        String name = "Croatia";

//        List<VisaDto> result = new LinkedList<>();
        countries = countryDao.getByName(name);
        for (Country country : countries){
//            System.out.println(country.getId());
            visas = visaDao.getByFieldName("country_id", country.getId().toString());
            for (Visa visa : visas){
                result.add(new VisaDto(countryDao.getById(visa.getCountryId()).getName(), null,
                        visa.getDateOfInit().toString(), visa.getDateOfExpired().toString()));
            }
        }
        System.out.println(result.size());

    }
}
