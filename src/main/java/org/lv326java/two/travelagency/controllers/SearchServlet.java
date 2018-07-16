package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.BookingDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.exceptions.InvalidDateException;
import org.lv326java.two.travelagency.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    private CityService cityService;
    private CountryService countryService;
    private HotelService hotelService;
    private BookingService bookingService;
    private UserService userService;

    public SearchServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        cityService = serviceDaoConteiner.getCityService();
        hotelService = serviceDaoConteiner.getHotelService();
        countryService = serviceDaoConteiner.getCountryService();
        bookingService = serviceDaoConteiner.getBookingService();
        userService = serviceDaoConteiner.getUserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String checkin = request.getParameter(ParametersEnum.ENTRY_DATE.toString());
            String checkout = request.getParameter(ParametersEnum.OUT_DATE.toString());
            try{
                bookingService.checkDate(Date.valueOf(checkin), Date.valueOf(checkout));
            } catch (InvalidDateException e) {
                request.setAttribute(ParametersEnum.ERROR.toString(), "Date is invalid. Please try again");
                request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
            }
            String cityId = request.getParameter(ParametersEnum.CITY_ID.toString());
            LoginDto loginDto = (LoginDto) request.getSession().getAttribute(ParametersEnum.LOGIN_DTO.toString());
            boolean onlyAvailableCountries = Boolean.valueOf(request.getParameter(ParametersEnum.ONLY_AVAILABLE_COUNTRIES.toString()));
            Long userId = userService.getIdUserByLogin(loginDto);
            List<BookingDto> bookingDtoList = bookingService.searchHotels(checkin, checkout, Long.parseLong(cityId),
                    userId, onlyAvailableCountries);
            request.setAttribute(ParametersEnum.BOOKING_DTO_LIST.toString(), bookingDtoList);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.HOTELS_JSP.toString())
                    .forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            String countryId = request.getParameter(ParametersEnum.COUNTRY_ID.toString());
            if (countryId == null) {
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.setAttribute(ParametersEnum.COUNTRY_ID.toString(), 2);
            } else {
                request.setAttribute(ParametersEnum.COUNTRY_ID.toString(), countryId);
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getCitiesByCountryId(
                        Long.parseLong(countryId)));
            }
            request.getRequestDispatcher(ViewUrls.SEARCH_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}
