package org.lv326java.two.travelagency.controllers;

import org.lv326java.two.travelagency.dto.LoginDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class Security {
    public static boolean isActiveSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        Cookie idSessionCookie = null;
        for (Cookie currentCookie : request.getCookies()) {
            System.out.println(currentCookie.getName());
            System.out.println(currentCookie.getValue());
            if (currentCookie.getName().equals("id_session")) {
                idSessionCookie = currentCookie;
                break;
            }
        }
        return (idSessionCookie != null)
                && (session.getAttribute("loginDto") != null)
                && (((LoginDto) (session.getAttribute("loginDto"))).getLogin() != null)
                && (idSessionCookie.getValue().equals(session.getId()));
    }

}
