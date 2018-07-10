package org.lv326java.two.travelagency.controllers;

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
            String cityName = request.getParameter("cityName");
            Date checkin = Date.valueOf(request.getParameter("entryDate"));
            Date checkout = Date.valueOf(request.getParameter("outDate"));
            request.setAttribute("hotels", hotelService.searchHotels(checkin, checkout, cityName));
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
            request.setAttribute("cities", cityService.getAllCitiesDto());
            request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
