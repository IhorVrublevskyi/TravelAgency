package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.Country;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountryDao extends AbstractDaoCRUD<Country> {

    private final static String ID_FIELDNAME = "id";
    private final static String NAME_FIELDNAME = "name";

    public CountryDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Country.CountryEntityQueries countryEntityQueries : Country.CountryEntityQueries.values()) {
            sqlQueries.put(countryEntityQueries.getSqlQuery(), countryEntityQueries);
        }
    }

    @Override
    protected Country createInstance(Map<String, String> args) {
        return new Country(
                Long.parseLong(args.get(ID_FIELDNAME)),
                args.get(NAME_FIELDNAME));
    }

    @Override
    protected Map<String, String> getUpdateFields(Country entity) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(NAME_FIELDNAME, allFields.get(NAME_FIELDNAME));
        result.put(ID_FIELDNAME, allFields.get(ID_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Country entity) {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(NAME_FIELDNAME, entity.getName());
        return fields;
    }

    public List<Country> getByName(String name) {
        return getByFieldName(NAME_FIELDNAME, name);
    }
}
