package org.lv326java.two.travelagency.controllers.users;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.exceptions.PasswordMismatchException;
import org.lv326java.two.travelagency.exceptions.UserAlreadyExistsException;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
import org.lv326java.two.travelagency.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    public RegistrationServlet() {
        userService = ServiceDaoConteiner.get().getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationDto registrationDto = new RegistrationDto(
                request.getParameter(ParametersEnum.FIRST_NAME.toString()),
                request.getParameter(ParametersEnum.LAST_NAME.toString()),
                request.getParameter(ParametersEnum.LOGIN.toString()),
                request.getParameter(ParametersEnum.PASSWORD.toString()),
                request.getParameter(ParametersEnum.RETYPE_PASSWORD.toString()));

        try {
            userService.createNewUser(registrationDto);
        } catch (PasswordMismatchException e) {
            request.setAttribute(ParametersEnum.ERROR.toString(), "Passwords didn`t match. Please try again.");
            request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
        } catch (UserAlreadyExistsException e) {
            request.setAttribute(ParametersEnum.ERROR.toString(), "User already exists. Please log in.");
            request.getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + ControllerUrls.LOGIN_SERVLET.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
    }
}
