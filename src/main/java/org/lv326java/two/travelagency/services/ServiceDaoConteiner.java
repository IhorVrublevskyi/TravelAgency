package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.*;

public final class ServiceDaoConteiner {

    private static volatile ServiceDaoConteiner instance = null;
    //
    private UserDao userDao;
    private RoleDao roleDao;
    private VisaDao visaDao;
    private CountryDao countryDao;
    private CityDao cityDao;
    private HotelDao hotelDao;
    private RoomDao roomDao;
    private BookingDao bookingDao;
    //
    private UserService userService;
    private VisaService visaService;
    private CountryService countryService;
    private CityService cityService;
    private HotelService hotelService;
    private RoleService roleService;
    private BookingService bookingService;
    private RoomService roomService;

    private ServiceDaoConteiner() {
        initDaos();
        initServices();
    }

    private void initDaos() {
        visaDao = new VisaDao();
        userDao = new UserDao();
        countryDao = new CountryDao();
        cityDao = new CityDao();
        hotelDao = new HotelDao();
        roomDao = new RoomDao();
        roleDao = new RoleDao();
        bookingDao = new BookingDao();
    }

    private void initServices() {
        userService = new UserService(userDao, roleDao);
        visaService = new VisaService(countryDao, userDao, visaDao);
        countryService = new CountryService(countryDao);
        cityService = new CityService(cityDao, countryDao);
        hotelService = new HotelService(hotelDao, cityDao, countryDao, roomDao);
        roleService = new RoleService(roleDao);
        bookingService = new BookingService(bookingDao, countryDao, cityDao, hotelDao, roomDao, visaDao);
        roomService = new RoomService(roomDao);
    }

    public static ServiceDaoConteiner get() {
        if (instance == null) {
            synchronized (ServiceDaoConteiner.class) {
                if (instance == null) {
                    instance = new ServiceDaoConteiner();
                }
            }
        }
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public VisaDao getVisaDao() {
        return visaDao;
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public HotelDao getHotelDao() {
        return hotelDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public UserService getUserService() {
        return userService;
    }

    public VisaService getVisaService() {
        return visaService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public CityService getCityService() {
        return cityService;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public BookingDao getBookingDao() {
        return bookingDao;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public RoomService getRoomService() {
        return roomService;
    }
}
