package org.lv326java.two.travelagency.controllers.users;

import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.exceptions.PasswordMismatchException;
import org.lv326java.two.travelagency.exceptions.UserAlreadyExistsException;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        RegistrationDto registrationDto = new RegistrationDto(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("retypePassword"));

        HttpSession httpSession = request.getSession();
        try {
            userService.createNewUser(registrationDto);
        } catch (PasswordMismatchException e) {
            request.setAttribute("error", "Passwords didn`t match. Please try again.");
            request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
        } catch (UserAlreadyExistsException e) {
            request.setAttribute("error", "User already exists. Please log in.");
            request.getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request, response);
        }
            httpSession.setAttribute("login", request.getParameter("login"));
            request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
    }
}
