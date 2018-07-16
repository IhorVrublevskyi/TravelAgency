package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.BookingService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RoomLoadServlet")
public class RoomLoadServlet extends HttpServlet {
    private BookingService bookingService;

    public RoomLoadServlet() {
        this.bookingService = ServiceDaoConteiner.get().getBookingService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                Date startDate = Date.valueOf(request.getParameter(ParametersEnum.ENTRY_DATE.toString()));
                Date endDate = Date.valueOf(request.getParameter(ParametersEnum.OUT_DATE.toString()));
                request.setAttribute(ParametersEnum.ROOM_STATS_DTO_LIST.toString(),
                        bookingService.getRoomLoadStats(startDate, endDate));
                request.getRequestDispatcher(ViewUrls.ROOM_LOAD_VIEW_JSP.toString()).forward(request, response);
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                request.getRequestDispatcher(ViewUrls.ROOM_LOAD_SEARCH_JSP.toString()).forward(request, response);
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
