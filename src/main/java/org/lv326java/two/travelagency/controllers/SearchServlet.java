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
        request.setAttribute("hotels", hotelService.getAllHotels());
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.HOTELS_JSP.toString())
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cities", cityService.getAllCitiesDto());
        request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
    }
}
