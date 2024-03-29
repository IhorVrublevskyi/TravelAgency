package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.dto.VisaDto;
import org.lv326java.two.travelagency.exceptions.InvalidDateException;
import org.lv326java.two.travelagency.services.CountryService;
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
import java.sql.Date;

@WebServlet(name = "VisaServlet")
public class VisaServlet extends HttpServlet {

    private VisaService visaService;
    private CountryService countryService;
    private UserService userService;

    public VisaServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        visaService = serviceDaoConteiner.getVisaService();
        countryService = serviceDaoConteiner.getCountryService();
        userService = serviceDaoConteiner.getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession httpSession = request.getSession();
            try{
            VisaDto visaDto = new VisaDto(
                    request.getParameter(ParametersEnum.COUNTRY_ID.toString()),
                    userService.getIdUserByLogin(
                            (LoginDto)httpSession.getAttribute(ParametersEnum.LOGIN_DTO.toString())).toString(),
                    request.getParameter(ParametersEnum.ENTRY_DATE.toString()),
                    request.getParameter(ParametersEnum.OUT_DATE.toString()));
            visaService.addVisa(visaDto);
            } catch (InvalidDateException e) {
                request.setAttribute(ParametersEnum.ERROR.toString(), "Date is invalid. Please try again");
                request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
                request.getRequestDispatcher(ViewUrls.VISA_JSP.toString()).forward(request, response);
            }
            response.sendRedirect(request.getContextPath() + ControllerUrls.USERCABINET_SERVLET);
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
            request.setAttribute(ParametersEnum.COUNTRY_DTO_LIST.toString(), countryService.getAllCountriesDto());
            request.getRequestDispatcher(ViewUrls.VISA_JSP.toString()).forward(request, response);
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }

    }

}
