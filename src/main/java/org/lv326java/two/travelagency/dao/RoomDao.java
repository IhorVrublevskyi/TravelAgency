package org.lv326java.two.travelagency.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.lv326java.two.travelagency.entities.Room;

import java.util.HashMap;
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
        for (Room.UserEntityQueries userEntityQueries : Room.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
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
        Map<String, String> result = new HashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(ROOM_NUMBER_FIELDNAME, allFields.get(ROOM_NUMBER_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Room entity) {
        Map<String, String> fields = new HashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(ROOM_NUMBER_FIELDNAME, entity.getRoomNumber().toString());
        fields.put(HOTEL_ID_FIELDNAME, entity.getHotelId().toString());
        return fields;
    }
}