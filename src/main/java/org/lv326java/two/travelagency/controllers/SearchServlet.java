package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.services.CityService;
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
    private HotelService hotelService;

    public SearchServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        cityService = serviceDaoConteiner.getCityService();
        hotelService = serviceDaoConteiner.getHotelService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String cityName = request.getParameter(ParametersEnum.CITY_NAME.toString());
            Date checkin = Date.valueOf(request.getParameter(ParametersEnum.ENTRY_DATE.toString()));
            Date checkout = Date.valueOf(request.getParameter(ParametersEnum.OUT_DATE.toString()));
            request.setAttribute(ParametersEnum.HOTEL_DTO_LIST.toString(), hotelService.searchHotels(checkin, checkout, cityName));
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
            request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getAllCitiesDto());
            request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
