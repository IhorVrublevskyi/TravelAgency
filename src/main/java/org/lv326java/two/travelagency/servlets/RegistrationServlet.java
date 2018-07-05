package org.lv326java.two.travelagency.servlets;

import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.entities.User;
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

        //for saving Login for Visa and "Hello login*"
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("loginSession", request.getParameter("login"));
        //

//print
//        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/home/kitty/text.txt"),true), true);
//        pw.println("fName = " + request.getParameter("firstName") + " lName = "+ request.getParameter("password")+" login = " + request.getParameter("login") + " password = "+ request.getParameter("password"));
//        pw.close();
//print

        request.setAttribute("registrationDto", registrationDto);

        if (!userService.isExist(registrationDto)){
            if(userService.checkPassword(registrationDto)){
                UserDao userDao = new UserDao();
                userDao.insert(new User(
                        null,
                        registrationDto.getFirstName(),
                        registrationDto.getLastName(),
                        registrationDto.getLogin(),
                        registrationDto.getPassword(),
                        1L));
                request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
            } else {
                request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
            }
        } else {
            request.getRequestDispatcher(ViewUrls.INDEX_JSP.toString()).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()).forward(request, response);
    }
}
