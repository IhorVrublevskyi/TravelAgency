package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.constants.ActionConstants;
import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.CountryDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AdminCountryServlet")
public class AdminCountryServlet extends HttpServlet {

    private CountryService countryService;


    public AdminCountryServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        countryService = serviceDaoConteiner.getCountryService();
    }

    public AdminCountryServlet(CountryService countryService) {
        this.countryService = countryService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                String id = request.getParameter(ParametersEnum.COUNTRY_ID.toString());
                switch (request.getParameter(ParametersEnum.ACTION.toString())) {
                    case ActionConstants.EDIT_FORM:
                        CountryDto countryDto = countryService.getCountryDtoById(Long.parseLong(id));
                        request.setAttribute(ParametersEnum.CURRENT_COUNTRY.toString(), countryDto);
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.UPDATE);
                        request.getRequestDispatcher(ViewUrls.ADMIN_COUNTRIES_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.INSERT_FORM:
                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.INSERT);
                        request.getRequestDispatcher(ViewUrls.ADMIN_COUNTRIES_INSERT_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.UPDATE:
                        countryService.updateContry(new CountryDto(
                                id,
                                request.getParameter(ParametersEnum.COUNTRY_NAME.toString())
                        ));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCOUNTRY_SERVLET);
                        break;
                    case ActionConstants.INSERT:
                        countryService.insertCountry(new CountryDto(
                                "0",
                                request.getParameter(ParametersEnum.COUNTRY_NAME.toString())
                        ));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCOUNTRY_SERVLET);
                        break;
                    case ActionConstants.DELETE:
                        countryService.deleteCountryById(Long.parseLong(id));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINCOUNTRY_SERVLET);
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
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.getRequestDispatcher(ViewUrls.ADMIN_COUNTRY_JSP.toString()).forward(request, response);
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

