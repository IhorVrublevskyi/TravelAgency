package org.lv326java.two.travelagency.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookingServlet")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("test", request.getParameterMap());
        request.getRequestDispatcher(ViewUrls.INFO_ABOUT_SELECTED_HOTEL_JSP.toString()).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.INFO_ABOUT_SELECTED_HOTEL_JSP.toString()).forward(request, response);
    }
}
