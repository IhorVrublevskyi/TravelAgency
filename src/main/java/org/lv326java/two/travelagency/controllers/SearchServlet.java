package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.services.CityService;
import org.lv326java.two.travelagency.services.CountryService;
import org.lv326java.two.travelagency.services.HotelService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    private CityService cityService;
    private CountryService countryService;
    private HotelService hotelService;

    public SearchServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        cityService = serviceDaoConteiner.getCityService();
        hotelService = serviceDaoConteiner.getHotelService();
        countryService = serviceDaoConteiner.getCountryService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String cityId= request.getParameter(ParametersEnum.CITY_ID.toString());
            Date checkin = Date.valueOf(request.getParameter(ParametersEnum.ENTRY_DATE.toString()));
            Date checkout = Date.valueOf(request.getParameter(ParametersEnum.OUT_DATE.toString()));
            request.setAttribute(ParametersEnum.HOTEL_DTO_LIST.toString(),
                    hotelService.searchHotels(checkin, checkout, Long.parseLong(cityId)));
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.HOTELS_JSP.toString())
                    .forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String countryId = request.getParameter(ParametersEnum.COUNTRY_ID.toString());
            if (countryId == null) {
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.setAttribute(ParametersEnum.COUNTRY_ID.toString(), "1");
            } else {
                request.setAttribute(ParametersEnum.COUNTRY_ID.toString(), countryId);
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getCitiesByCountryId(
                        Long.parseLong(countryId)));
            }
            request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
