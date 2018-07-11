package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.ViewUrls;
import org.lv326java.two.travelagency.services.HotelService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
import org.lv326java.two.travelagency.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminUserServlet")
public class AdminUserServlet extends HttpServlet {

    private UserService userService;


    public AdminUserServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        userService = serviceDaoConteiner.getUserService();
    }

    public AdminUserServlet(UserService userService) {
        this.userService = userService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("usersAdmin", userService.getAllUsers());
        System.out.println(session.getAttribute("usersAdmin"));


        request.getRequestDispatcher(ViewUrls.ADMIN_USERS_JSP.toString()).forward(request, response);
    }
}

