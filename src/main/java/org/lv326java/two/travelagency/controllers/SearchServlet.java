package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.services.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityService cityService = new CityService();
        request.setAttribute("cities", cityService.getAllCitiesDto());
        request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
    }
}
