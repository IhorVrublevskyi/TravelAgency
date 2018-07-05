package org.lv326java.two.travelagency.controllers;

public enum ViewUrls {
    INFO_ABOUT_SELECTED_HOTEL_JSP("WEB-INF/pages/infoAboutSelectedHotel.jsp"),
    HOTEL_CONFIRM_JSP("WEB-INF/pages/hotelConfirm.jsp"),
    USER_CABINET_JSP("WEB-INF/pages/userCabinet.jsp"),
    ADMIN_CABINET_JSP("WEB-INF/pages/adminsCabinet.jsp"),
    INDEX_JSP("WEB-INF/pages/index.js"),
    REGISTRATION_JSP("WEB-INF/pages/registration.jsp"),
    HOTELS_JSP("WEB-INF/pages/hotels.jsp"),
    THANKS_JSP("WEB-INF/pages/thanks.jsp"),
    VISA_JSP("WEB-INF/pages/visa.jsp");
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
