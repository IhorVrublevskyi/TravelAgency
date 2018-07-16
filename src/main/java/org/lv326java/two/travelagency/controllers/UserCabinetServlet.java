package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.Booking;
import org.lv326java.two.travelagency.services.BookingService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
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

    private VisaService visaService;
    private BookingService bookingService;
    private UserService userService;

    public UserCabinetServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        this.visaService = serviceDaoConteiner.getVisaService();
        this.bookingService = serviceDaoConteiner.getBookingService();
        this.userService = serviceDaoConteiner.getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = ((LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString()));
            request.setAttribute(ParametersEnum.USER_VISAS.toString(),
                    visaService.getVisaByUserLogin(loginDto.getLogin()));
            request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(),
                    bookingService.getVisitedCountriesByUserId(userService.getIdUserByLogin(loginDto)));
            request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
