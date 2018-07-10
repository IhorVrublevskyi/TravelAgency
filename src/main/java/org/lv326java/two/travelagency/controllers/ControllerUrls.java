package org.lv326java.two.travelagency.controllers;

public enum ControllerUrls {
    ROOT_SERVLET("/"),
    LOGIN_SERVLET("/login"),
    LOGOUT_SERVLET("/logout"),
    USERCABINET_SERVLET("/userCabinet"),
    ADMINCABINET_SERVLET("/adminsCabinet");

    private String url;

    private ControllerUrls(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
