package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.Visa;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class VisaDao extends AbstractDaoCRUD<Visa> {

    private final static String ID_FIELDNAME = "id";
    private final static String DATE_OF_INIT_FIELDNAME = "date_of_init";
    private final static String DATE_OF_EXPIRED_FIELDNAME = "date_of_expired";
    private final static String COUNTRY_ID_FIELDNAME = "country_id";
    private final static String USER_ID_FIELDNAME = "user_id";

    public VisaDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Visa.VisaEntityQueries visaEntityQueries : Visa.VisaEntityQueries.values()) {
            sqlQueries.put(visaEntityQueries.getSqlQuery(), visaEntityQueries);
        }
    }

    @Override
    protected Visa createInstance(Map<String, String> args) {
        return new Visa(Long.parseLong(args.get(ID_FIELDNAME)),
                Long.parseLong(args.get(COUNTRY_ID_FIELDNAME)),
                Long.parseLong(args.get(USER_ID_FIELDNAME)),
                Date.valueOf(args.get(DATE_OF_INIT_FIELDNAME)),
                Date.valueOf(args.get(DATE_OF_EXPIRED_FIELDNAME)));
    }

    @Override
    protected Map<String, String> getUpdateFields(Visa entity) {
        //Map<String, String> result = new LinkedHashMap<>();
        //Map<String, String> allFields = getFields(entity);
        return null;//result;
    }

    @Override
    protected Map<String, String> getFields(Visa entity) {
        Map<String, String> fields = new LinkedHashMap<>();
        if(entity.getId() != null){
            fields.put(ID_FIELDNAME, entity.getId().toString());
        } else {
            fields.put(ID_FIELDNAME, null);
        }
        fields.put(COUNTRY_ID_FIELDNAME, entity.getCountryId().toString());
        fields.put(USER_ID_FIELDNAME, entity.getUserId().toString());
        fields.put(DATE_OF_INIT_FIELDNAME, entity.getDateOfInit().toString());
        fields.put(DATE_OF_EXPIRED_FIELDNAME, entity.getDateOfExpired().toString());
        return fields;
    }
}
