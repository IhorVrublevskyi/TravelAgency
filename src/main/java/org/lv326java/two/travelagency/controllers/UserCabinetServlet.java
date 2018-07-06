package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.UserService;
import org.lv326java.two.travelagency.services.VisaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserCabinetServlet")
public class UserCabinetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        VisaService visaService = new VisaService();
        request.setAttribute("userVisas", visaService.getVisaByUserLogin(String.valueOf(session.getAttribute("login"))));

        request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
    }
}
