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
        if (userService.isValid(loginDto)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loginDto", loginDto);
            response.addCookie(new Cookie("id_session", session.getId()));

            if (ServiceDaoConteiner.get().getUserDao().getUserEntityByLogin(loginDto.getLogin()).getRoleId() == 1) {
                response.sendRedirect(request.getContextPath() + ControllerUrls.USERCABINET_SERVLET);
            } else {
                //TODO AdminCabinet
                response.sendRedirect(request.getContextPath() + ControllerUrls.USERCABINET_SERVLET);
            }
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

