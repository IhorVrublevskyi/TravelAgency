package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ActionConstants;
import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.CityDto;
import org.lv326java.two.travelagency.dto.HotelDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.CityService;
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
    private CityService cityService;

    public AdminHotelServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        hotelService = serviceDaoConteiner.getHotelService();
        cityService = serviceDaoConteiner.getCityService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                String id = request.getParameter(ParametersEnum.HOTEL_ID.toString());
                HotelDto hotelDto;
                switch (request.getParameter(ParametersEnum.ACTION.toString())) {
                    case ActionConstants.EDIT_FORM:
                        hotelDto = hotelService.getHotelDtoById(Long.parseLong(id));
                        hotelDto.setId(id);
                        request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getAllCitiesDto());
                        request.setAttribute(ParametersEnum.CURRENT_HOTEL.toString(), hotelDto);
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.UPDATE);
                        request.getRequestDispatcher(ViewUrls.ADMIN_HOTEL_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.INSERT_FORM:
                        request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getAllCitiesDto());
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.INSERT);
                        request.getRequestDispatcher(ViewUrls.ADMIN_HOTEL_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.UPDATE:
                        hotelDto = new HotelDto(
                                null,
                                request.getParameter(ParametersEnum.CITY_ID.toString()),
                                request.getParameter(ParametersEnum.HOTEL_NAME.toString()),
                                request.getParameter(ParametersEnum.HOTEL_ADDRESS.toString()));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINHOTEL_SERVLET);
                        hotelDto.setId(id);
                        hotelService.updateHotel(hotelDto);
                        break;
                    case ActionConstants.INSERT:
                        hotelDto = new HotelDto(
                                null,
                                request.getParameter(ParametersEnum.CITY_ID.toString()),
                                request.getParameter(ParametersEnum.HOTEL_NAME.toString()),
                                request.getParameter(ParametersEnum.HOTEL_ADDRESS.toString()));
                        hotelService.insertHotel(hotelDto);
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINHOTEL_SERVLET);
                        break;
                    case ActionConstants.DELETE:
                        hotelService.deleteHotelById(Long.parseLong(id));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINHOTEL_SERVLET);
                        break;
                }
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                request.setAttribute(ParametersEnum.HOTEL_DTO_LIST.toString(), hotelService.getAllHotelsDto());
                request.getRequestDispatcher(ViewUrls.ADMIN_HOTELS_JSP.toString()).forward(request, response);
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

