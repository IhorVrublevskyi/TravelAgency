package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.entities.Role;

import java.util.HashMap;
import java.util.Map;

public class RoleDao extends AbstractDaoCRUD<Role> {

    private final static String ID_FIELDNAME = "id";
    private final static String NAME_FIELDNAME = "name";

    public RoleDao() {
        super();
        init();
    }

    @Override
    protected void init() {
        for (Role.RoleEntityQueries roleEntityQueries : Role.RoleEntityQueries.values()) {
            sqlQueries.put(roleEntityQueries.getSqlQuery(), roleEntityQueries);
        }
    }

    @Override
    protected Role createInstance(Map<String, String> args) {
        return new Role(
                Long.parseLong(args.get(ID_FIELDNAME)),
                args.get(NAME_FIELDNAME));
    }

    @Override
    protected Map<String, String> getUpdateFields(Role entity) {
        Map<String, String> result = new HashMap<>();
        Map<String, String> allFields = getFields(entity);
        result.put(NAME_FIELDNAME, allFields.get(NAME_FIELDNAME));
        return result;
    }

    @Override
    protected Map<String, String> getFields(Role entity) {
        Map<String, String> fields = new HashMap<>();
        fields.put(ID_FIELDNAME, entity.getId().toString());
        fields.put(NAME_FIELDNAME, entity.getName());
        return fields;
    }

    public Role getRoleEntityByName(String name) {
        return getByFieldName(NAME_FIELDNAME, name).get(0);
    }
}
