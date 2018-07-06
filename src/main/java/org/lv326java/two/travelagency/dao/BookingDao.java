package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.Booking;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookingDao extends AbstractDaoCRUD<Booking> {

    private final static String ID_FIELDNAME = "id";
    private final static String USER_ID_FIELDNAME = "user_id";
    private final static String ROOM_ID_FIELDNAME = "room_id";
    private final static String DATE_CHECKIN_FIELDNAME = "date_checkin";
    private final static String DATE_CHECKOUT_FIELDNAME = "date_checkout";

    public BookingDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Booking.BookingEntityQueries bookingEntityQueries: Booking.BookingEntityQueries.values()) {
            sqlQueries.put(bookingEntityQueries.getSqlQuery(), bookingEntityQueries);
        }
    }

    @Override
    protected Booking createInstance(Map<String, String> args) {
        return new Booking(
                Long.parseLong(args.get(ID_FIELDNAME)),
                Long.parseLong(args.get(USER_ID_FIELDNAME)),
                Long.parseLong(args.get(ROOM_ID_FIELDNAME)),
                Date.valueOf(args.get(DATE_CHECKIN_FIELDNAME)),
                Date.valueOf(args.get(DATE_CHECKOUT_FIELDNAME)));
    }

    @Override
    protected Map<String, String> getUpdateFields(Booking entity) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(USER_ID_FIELDNAME, allFields.get(USER_ID_FIELDNAME));
        result.put(ROOM_ID_FIELDNAME, allFields.get(ROOM_ID_FIELDNAME));
        result.put(DATE_CHECKIN_FIELDNAME, allFields.get(DATE_CHECKIN_FIELDNAME));
        result.put(DATE_CHECKOUT_FIELDNAME, allFields.get(DATE_CHECKOUT_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Booking entity) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(USER_ID_FIELDNAME, entity.getUserId().toString());
        fields.put(ROOM_ID_FIELDNAME, entity.getRoomId().toString());
        fields.put(DATE_CHECKIN_FIELDNAME, entity.getDateCheckin().toString());
        fields.put(DATE_CHECKOUT_FIELDNAME, entity.getDateCheckout().toString());
        return fields;
    }
}
