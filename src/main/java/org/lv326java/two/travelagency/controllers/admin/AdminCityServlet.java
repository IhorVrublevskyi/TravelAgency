package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.services.CityService;
import org.lv326java.two.travelagency.services.CountryService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminCityServlet")
public class AdminCityServlet extends HttpServlet {

    private CityService cityService;
    private CountryService countryService;


    public AdminCityServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        cityService = serviceDaoConteiner.getCityService();
        countryService = serviceDaoConteiner.getCountryService();
    }

    public AdminCityServlet(CityService cityService) {
        this.cityService = cityService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("citiesAdmin", cityService.getAllCitiesDto());



        request.getRequestDispatcher(ViewUrls.ADMIN_CITY_JSP.toString()).forward(request, response);
    }
}

