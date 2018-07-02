package org.lv326java.two.travelagency.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.lv326java.two.travelagency.entities.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HotelDao extends AbstractDaoCRUD<Hotel> {

    private final static String ID_FIELDNAME = "id";
    private final static String NAME_FIELDNAME = "name";
    private final static String CITY_ID_FIELDNAME = "city_id";
    private final static String ADDRESS_FIELDNAME = "address";


    public HotelDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Hotel.UserEntityQueries userEntityQueries : Hotel.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    @Override
    protected Hotel createInstance(Map<String, String> args) {
        return new Hotel(
                Long.parseLong(args.get(ID_FIELDNAME)),
                args.get(NAME_FIELDNAME),
                Long.parseLong(args.get(CITY_ID_FIELDNAME)),
                args.get(ADDRESS_FIELDNAME));
    }

    @Override
    protected Map<String, String> getUpdateFields(Hotel entity) {
        Map<String, String> result = new HashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(NAME_FIELDNAME, allFields.get(NAME_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Hotel entity) {
        Map<String, String> fields = new HashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(NAME_FIELDNAME, entity.getName());
        fields.put(CITY_ID_FIELDNAME, entity.getCityId().toString());
        fields.put(ADDRESS_FIELDNAME, entity.getAddress());
        return fields;
    }
}
