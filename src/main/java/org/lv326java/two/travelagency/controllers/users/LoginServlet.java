package org.lv326java.two.travelagency.controllers.users;

import org.lv326java.two.travelagency.controllers.ControllerUrls;
import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
import org.lv326java.two.travelagency.services.UserService;
import org.lv326java.two.travelagency.services.VisaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    public LoginServlet() {
        userService = ServiceDaoConteiner.get().getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginDto loginDto = new LoginDto(request.getParameter("login"), request.getParameter("password"));

        request.setAttribute("loginDto", loginDto);

        if (userService.isValid(loginDto)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", loginDto.getLogin());
            // Add Cookie
            Cookie cookie = new Cookie("id_session", session.getId());
            response.addCookie(cookie);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.USERCABINET_SERVLET.toString())
                    .forward(request, response);

        } else {
            request.setAttribute("error", "Bad Login or Password");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.LOGIN_JSP.toString())
                    .forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request, response);
    }
}

