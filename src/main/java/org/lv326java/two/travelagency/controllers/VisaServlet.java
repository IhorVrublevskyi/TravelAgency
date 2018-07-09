package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.VisaDto;
import org.lv326java.two.travelagency.entities.Visa;
import org.lv326java.two.travelagency.services.CountryService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
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

    public VisaServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        visaService = serviceDaoConteiner.getVisaService();
        countryService = serviceDaoConteiner.getCountryService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        VisaDto visaDto = new VisaDto(
                visaService.getIdCountryByName(request.getParameter("countryName")).toString(),
                visaService.getIdUserByLogin(String.valueOf(httpSession.getAttribute("login"))).toString(),
                request.getParameter("entryDate"),
                request.getParameter("outDate"));

        visaService.addVisa(visaDto);
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ControllerUrls.USERCABINET_SERVLET.toString())
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("countries", countryService.getAllCountriesDto());
        request.getRequestDispatcher(ViewUrls.VISA_JSP.toString()).forward(request, response);
    }

}
