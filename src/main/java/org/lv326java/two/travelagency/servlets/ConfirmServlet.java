package org.lv326java.two.travelagency.servlets;

import org.lv326java.two.travelagency.controllers.ViewUrls;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.HOTEL_CONFIRM_JSP.toString()).forward(request, response);
    }
}
