package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.City;

import java.util.HashMap;
import java.util.Map;

public class CityDao extends AbstractDaoCRUD<City> {

    private final static String ID_FIELDNAME = "id";
    private final static String NAME_FIELDNAME = "name";
    private final static String COUNTRY_ID_FIELDNAME = "country_id";

    public CityDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (City.UserEntityQueries userEntityQueries : City.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    @Override
    protected City createInstance(Map<String, String> args) {
        return new City(
                Long.parseLong(args.get(ID_FIELDNAME)),
                args.get(NAME_FIELDNAME),
                Long.parseLong(args.get(COUNTRY_ID_FIELDNAME)));
    }

    @Override
    protected Map<String, String> getUpdateFields(City entity) {
        Map<String, String> result = new HashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(NAME_FIELDNAME, allFields.get(NAME_FIELDNAME));
        result.put(COUNTRY_ID_FIELDNAME, allFields.get(COUNTRY_ID_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(City entity) {
        Map<String, String> fields = new HashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(NAME_FIELDNAME, entity.getName());
        fields.put(COUNTRY_ID_FIELDNAME, entity.getCountryId().toString());
        return fields;
    }
}