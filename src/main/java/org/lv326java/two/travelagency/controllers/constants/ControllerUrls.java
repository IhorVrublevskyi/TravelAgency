package org.lv326java.two.travelagency.controllers.constants;

public enum ControllerUrls {
    ROOT_SERVLET("/"),
    LOGIN_SERVLET("/login"),
    LOGOUT_SERVLET("/logout"),
    USERCABINET_SERVLET("/userCabinet"),
    ADMINCABINET_SERVLET("/adminsCabinet"),
    ADMINCOUNTRY_SERVLET("/countries"),
    ADMINCITY_SERVLET("/cities"),
    ADMINHOTEL_SERVLET("/hotels"),
    ADMINUSER_SERVLET("/users"),
    SEARCH_SERVLET("/search"),
    VISA_SERVLET("/visa");

    private String url;

    private ControllerUrls(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
