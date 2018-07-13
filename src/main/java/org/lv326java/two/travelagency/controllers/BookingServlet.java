package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.BookingDto;
import org.lv326java.two.travelagency.entities.Booking;
import org.lv326java.two.travelagency.services.BookingService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;

@WebServlet(name = "BookingServlet")
public class BookingServlet extends HttpServlet {

    private BookingService bookingService;

    public BookingServlet() {
        this.bookingService = ServiceDaoConteiner.get().getBookingService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
//            BookingDto bookingDto = ((BookingDto) request.getParameter(ParametersEnum.BOOKING_DTO.toString());
            System.out.println(request.getParameter(ParametersEnum.BOOKING_DTO.toString()));
//            bookingService.addBooking(()));
            request.getRequestDispatcher(ViewUrls.THANKS_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String userId = request.getParameter(ParametersEnum.USER_ID.toString());
            String roomId = request.getParameter(ParametersEnum.ROOM_ID.toString());
            String hotelId = request.getParameter(ParametersEnum.HOTEL_ID.toString());
            String hotelName = request.getParameter(ParametersEnum.HOTEL_NAME.toString());
            String hotelAddress = request.getParameter(ParametersEnum.HOTEL_ADDRESS.toString());
            String cityName = request.getParameter(ParametersEnum.CITY_NAME.toString());
            String countryName = request.getParameter(ParametersEnum.COUNTRY_NAME.toString());
            String dateCheckin = request.getParameter(ParametersEnum.ENTRY_DATE.toString());
            String dateCheckout = request.getParameter(ParametersEnum.OUT_DATE.toString());
            BookingDto bookingDto = new BookingDto(hotelId, hotelName, hotelAddress, countryName, cityName,
                    dateCheckin, dateCheckout);
            bookingDto.setRoomId(roomId);
            bookingDto.setUserId(userId);
            bookingService.addBooking(bookingDto);
            //request.setAttribute(ParametersEnum.CURRENT_BOOKING.toString(),bookingDto);
            request.getRequestDispatcher(ViewUrls.THANKS_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
