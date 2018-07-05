package org.lv326java.two.travelagency.servlets;

import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.VisaDto;
import org.lv326java.two.travelagency.entities.Visa;
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


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                HttpSession httpSession = request.getSession();

                VisaService visaService = new VisaService();
                VisaDto visaDto = new VisaDto(
                        visaService.getIdCountryByName(request.getParameter("cName")).toString(),
                        visaService.getIdUserByLogin(String.valueOf(httpSession.getAttribute("loginSession"))).toString(),
                        request.getParameter("entryDate"),
                        request.getParameter("outDate"));

                request.setAttribute("visaDto", visaDto);
//
                request.setAttribute("country", request.getParameter("cName"));
                request.setAttribute("entryDate", request.getParameter("entryDate"));
                request.setAttribute("outDate", request.getParameter("outDate"));
//
                VisaDao visaDao = new VisaDao();
                visaDao.insert(new Visa(
                        null,
                        Long.parseLong(visaDto.getCountry()),
                        Long.parseLong(visaDto.getUser()),
                        Date.valueOf(visaDto.getDateOfInit()),
                        Date.valueOf(visaDto.getDateOfExpired())));

            request.getRequestDispatcher("WEB-INF/pages/userCabinet.jsp").forward(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/visa.jsp").forward(request, response);
        }

}
