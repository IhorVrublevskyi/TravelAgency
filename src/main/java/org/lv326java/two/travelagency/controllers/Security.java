package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Security {

    private static final String ADMIN_ROLE = "admin";

    public static boolean isActiveSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        Cookie idSessionCookie = null;
        for (Cookie currentCookie : request.getCookies()) {
            if (currentCookie.getName().equals(ParametersEnum.SESSION_COOCKIE_NAME.toString())) {
                idSessionCookie = currentCookie;
                break;
            }
        }
        return (idSessionCookie != null)
                && (session.getAttribute(ParametersEnum.LOGIN_DTO.toString()) != null)
                && (((LoginDto) (session.getAttribute(ParametersEnum.LOGIN_DTO.toString()))).getLogin() != null)
                && (idSessionCookie.getValue().equals(session.getId()));
    }

    public static boolean isAdmin(LoginDto loginDto) {
        UserDao userDao = ServiceDaoConteiner.get().getUserDao();
        RoleDao roleDao = ServiceDaoConteiner.get().getRoleDao();
        return loginDto != null &&
                roleDao.getById(userDao.getUserEntityByLogin(loginDto.getLogin()).getRoleId()).getName().equals(ADMIN_ROLE);
    }
}
