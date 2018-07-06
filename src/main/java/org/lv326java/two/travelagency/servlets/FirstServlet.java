package org.lv326java.two.travelagency.servlets;

import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.UserService;
import org.lv326java.two.travelagency.services.VisaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        VisaService visaService = new VisaService();
        LoginDto loginDto = new LoginDto(request.getParameter("login"), request.getParameter("password"));

        request.setAttribute("loginDto", loginDto);

        //for saving Login for Visa
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("loginSession", loginDto.getLogin());
        httpSession.setAttribute("visas", userService.getVisaByUserLogin(loginDto.getLogin()));
        //


        if (userService.isValid(loginDto)) {
            if(userService.getRoleDao(loginDto).equals(1L)){
                request.getRequestDispatcher("WEB-INF/pages/userCabinet.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/pages/adminsCabinet.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
    }
}

