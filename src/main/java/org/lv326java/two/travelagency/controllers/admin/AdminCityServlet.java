package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ActionConstants;
import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.CityDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.CityService;
import org.lv326java.two.travelagency.services.CountryService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminCityServlet")
public class AdminCityServlet extends HttpServlet {

    private CityService cityService;
    private CountryService countryService;


    public AdminCityServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        cityService = serviceDaoConteiner.getCityService();
        countryService = serviceDaoConteiner.getCountryService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                String id = request.getParameter(ParametersEnum.CITY_ID.toString());
                switch (request.getParameter(ParametersEnum.ACTION.toString())) {
                    case ActionConstants.EDIT_FORM:
                        CityDto cityDto = cityService.getCityDtoById(Long.parseLong(id));
                        request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountries());
                        request.setAttribute(ParametersEnum.CURRENT_CITY.toString(), cityDto);
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.UPDATE);
                        request.getRequestDispatcher(ViewUrls.ADMIN_CITIES_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.INSERT_FORM:
                        request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountries());
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.INSERT);
                        request.getRequestDispatcher(ViewUrls.ADMIN_CITIES_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.UPDATE:
                        cityService.updateCity(new CityDto(
                                id,
                                request.getParameter(ParametersEnum.CITY_NAME.toString()),
                                request.getParameter(ParametersEnum.COUNTRY_NAME.toString())
                        ));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCITY_SERVLET);
                        break;
                    case ActionConstants.INSERT:
                        cityService.insertCity(new CityDto(
                                "0",
                                request.getParameter(ParametersEnum.CITY_NAME.toString()),
                                request.getParameter(ParametersEnum.COUNTRY_NAME.toString())
                        ));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCITY_SERVLET);
                        break;
                    case ActionConstants.DELETE:
                        cityService.deleteCityById(Long.parseLong(id));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCITY_SERVLET);
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
                request.setAttribute(ParametersEnum.CITY_DTO_LIST.toString(), cityService.getAllCitiesDto());
                request.getRequestDispatcher(ViewUrls.ADMIN_CITY_JSP.toString()).forward(request, response);
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

