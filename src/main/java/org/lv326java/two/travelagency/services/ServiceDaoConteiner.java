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
    //
    private UserService userService;
    private VisaService visaService;
    private CountryService countryService;
    private CityService cityService;
    private HotelService hotelService;

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
    }

    private void initServices() {
        userService = new UserService(userDao, roleDao);
        visaService = new VisaService(countryDao, userDao, visaDao);
        countryService = new CountryService(countryDao);
        cityService = new CityService(cityDao, countryDao);
        hotelService = new HotelService(hotelDao, cityDao, countryDao, roomDao);
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
}
