package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.ControllerUrls;
import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminCountryServlet")
public class AdminCountryServlet extends HttpServlet {

    private CountryService countryService;


    public AdminCountryServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        countryService = serviceDaoConteiner.getCountryService();
    }

    public AdminCountryServlet(CountryService countryService) {
        this.countryService = countryService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("countriesAdmin", countryService.getAllCountriesDto());
        System.out.println(countryService.getAllCountriesDto());
        request.getRequestDispatcher(ViewUrls.ADMIN_COUNTRY_JSP.toString()).forward(request, response);
    }
}

