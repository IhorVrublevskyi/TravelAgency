package org.lv326java.two.travelagency.controllers.users;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
import org.lv326java.two.travelagency.services.UserService;

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
        LoginDto loginDto = new LoginDto(request.getParameter(ParametersEnum.LOGIN.toString()),
                request.getParameter(ParametersEnum.PASSWORD.toString()));
        if (userService.isValidCredentials(loginDto)) {
            HttpSession session = request.getSession(true);
            session.setAttribute(ParametersEnum.LOGIN_DTO.toString(), loginDto);
            response.addCookie(new Cookie(ParametersEnum.SESSION_COOCKIE_NAME.toString(), session.getId()));
            if (Security.isAdmin(loginDto)) {
                response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCABINET_SERVLET);
            } else {
                response.sendRedirect(request.getContextPath() + ControllerUrls.USERCABINET_SERVLET);
            }
        } else {
            request.setAttribute(ParametersEnum.ERROR.toString(), "Bad Login or Password");
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

