package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminCabinetServlet")
public class AdminCabinetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                request.getRequestDispatcher(ViewUrls.ADMIN_CABINET_JSP.toString()).forward(request, response);
            } else {
                request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
            }
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
