package org.lv326java.two.travelagency.dao;


import org.lv326java.two.travelagency.entities.User;

import java.util.LinkedHashMap;
import java.util.Map;

public final class UserDao extends AbstractDaoCRUD<User> {

    private final static String ID_FIELDNAME = "id";
    private final static String FIRST_NAME_FIELDNAME = "first_name";
    private final static String LAST_NAME_FIELDNAME = "last_name";
    private final static String LOGIN_FIELDNAME = "login";
    private final static String PASSWORD_FIELDNAME = "password";
    private final static String ROLE_ID_FIELDNAME = "roles_id";

    public UserDao() {
        super();
        init();
    }

    // TODO Create abstract method in ADao
    @Override
    protected void init() {
        for (User.UserEntityQueries userEntityQueries : User.UserEntityQueries.values()) {
            sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
        }
    }

    @Override
    protected User createInstance(Map<String, String> args) {
        return new User(
                Long.parseLong(args.get(ID_FIELDNAME) == null ? "" : args.get(ID_FIELDNAME)),
                args.get(FIRST_NAME_FIELDNAME) == null ? "" : args.get(FIRST_NAME_FIELDNAME),
                args.get(LAST_NAME_FIELDNAME) == null ? "" : args.get(LAST_NAME_FIELDNAME),
                args.get(LOGIN_FIELDNAME) == null ? "" : args.get(LOGIN_FIELDNAME),
                args.get(PASSWORD_FIELDNAME) == null ? "" : args.get(PASSWORD_FIELDNAME),
                Long.parseLong(args.get(ROLE_ID_FIELDNAME) == null ? "0" : args.get(ROLE_ID_FIELDNAME)));
    }

    @Override
    protected Map<String, String> getUpdateFields(User entity) {
        Map<String, String> result = new LinkedHashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(FIRST_NAME_FIELDNAME, allFields.get(FIRST_NAME_FIELDNAME));
        result.put(LAST_NAME_FIELDNAME, allFields.get(LAST_NAME_FIELDNAME));
        result.put(PASSWORD_FIELDNAME, allFields.get(PASSWORD_FIELDNAME));
        result.put(ROLE_ID_FIELDNAME, allFields.get(ROLE_ID_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(User entity) {
        Map<String, String> fields = new LinkedHashMap<>();
        if(entity.getId() != null){
            fields.put(ID_FIELDNAME, entity.getId().toString());
        } else {
            fields.put(ID_FIELDNAME, null);
        }
        fields.put(FIRST_NAME_FIELDNAME, entity.getFirstName());
        fields.put(LAST_NAME_FIELDNAME, entity.getLastName());
        fields.put(LOGIN_FIELDNAME, entity.getLogin());
        fields.put(PASSWORD_FIELDNAME, entity.getPassword());
        fields.put(ROLE_ID_FIELDNAME, entity.getRoleId().toString());
        return fields;
    }

    public User getUserEntityByLogin(String login) {
        return getByFieldName(LOGIN_FIELDNAME, login).get(0);
    }

}
