package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.Room;
import org.lv326java.two.travelagency.entities.SqlQueries;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoomDao extends AbstractDaoCRUD<Room> {

    private final static String ID_FIELDNAME = "id";
    private final static String ROOM_NUMBER_FIELDNAME = "room_number";
    private final static String HOTEL_ID_FIELDNAME = "hotel_id";

    public RoomDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Room.RoomEntityQueries roomEntityQueries : Room.RoomEntityQueries.values()) {
            sqlQueries.put(roomEntityQueries.getSqlQuery(), roomEntityQueries);
        }
    }

    @Override
    protected Room createInstance(Map<String, String> args) {
        return new Room(
                Long.parseLong(args.get(ID_FIELDNAME)),
                Integer.parseInt(args.get(ROOM_NUMBER_FIELDNAME)),
                Long.parseLong(args.get(HOTEL_ID_FIELDNAME)));
    }

    @Override
    protected Map<String, String> getUpdateFields(Room entity) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(ROOM_NUMBER_FIELDNAME, allFields.get(ROOM_NUMBER_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Room entity) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put(ID_FIELDNAME, entity.getId() != null ? entity.getId().toString() : null);
        fields.put(ROOM_NUMBER_FIELDNAME, entity.getRoomNumber().toString());
        fields.put(HOTEL_ID_FIELDNAME, entity.getHotelId().toString());
        return fields;
    }

    public List<Room> getFreeRoomsByPeriod(Date startDate, Date endDate) {
        String sql = "SELECT rooms.id, rooms.room_number, rooms.hotel_id FROM cities LEFT JOIN hotels " +
                "ON cities.id = hotels.city_id JOIN rooms ON hotels.id = " +
                "rooms.hotel_id LEFT JOIN bookings ON rooms.id = bookings.room_id WHERE (bookings.date_checkin > " +
                "'%s' OR bookings.date_checkin IS NULL OR bookings.date_checkout < '%s' OR " +
                "bookings.date_checkout IS NULL);";
        sql = String.format(sql, endDate, startDate);
        return getQueryResult(sql, SqlQueries.GET_BY_FIELD);
    }



}