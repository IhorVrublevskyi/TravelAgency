package org.lv326java.two.travelagency.controllers.constants;

public enum ViewUrls {
    LOGIN_JSP("/WEB-INF/pages/login.jsp"),
    INFO_ABOUT_SELECTED_HOTEL_JSP("/WEB-INF/pages/infoAboutSelectedHotel.jsp"),
    HOTEL_CONFIRM_JSP("/WEB-INF/pages/hotelConfirm.jsp"),
    USER_CABINET_JSP("/WEB-INF/pages/userCabinet.jsp"),
    ADMIN_CABINET_JSP("/WEB-INF/pages/admin/adminsCabinet.jsp"),
    REGISTRATION_JSP("/WEB-INF/pages/registration.jsp"),
    HOTELS_JSP("/WEB-INF/pages/hotels.jsp"),
    THANKS_JSP("/WEB-INF/pages/thanks.jsp"),
    VISA_JSP("/WEB-INF/pages/visa.jsp"),
    SEARCH_JSP("/WEB-INF/pages/search.jsp"),
    ADMIN_COUNTRIES_JSP("/WEB-INF/pages/admin/countries.jsp"),
    ADMIN_CITIES_JSP("/WEB-INF/pages/admin/cities.jsp"),
    ADMIN_HOTELS_JSP("/WEB-INF/pages/admin/hotels.jsp"),
    ADMIN_USERS_JSP("/WEB-INF/pages/admin/users.jsp"),
    ADMIN_COUNTRY_INSERT_UPDATE_JSP("/WEB-INF/pages/admin/insertUpdateCountry.jsp"),
    ADMIN_CITY_INSERT_UPDATE_JSP("/WEB-INF/pages/admin/insertUpdateCity.jsp"),
    ADMIN_HOTEL_INSERT_UPDATE_JSP("/WEB-INF/pages/admin/insertUpdateHotel.jsp"),
    ADMIN_USER_UPDATE_JSP("/WEB-INF/pages/admin/updateUser.jsp");
    //
    private String url;

    private ViewUrls(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
