package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.services.HotelService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminCityServlet")
public class AdminHotelServlet extends HttpServlet {

    private HotelService hotelService;


    public AdminHotelServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        hotelService = serviceDaoConteiner.getHotelService();
    }

    public AdminHotelServlet(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("hotelsAdmin", hotelService.getAllHotels());



        request.getRequestDispatcher(ViewUrls.ADMIN_HOTELS_JSP.toString()).forward(request, response);
    }
}

