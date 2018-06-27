package org.lv326java.two.travelagency.entities;

public class Hotel implements Entity {

    public static enum UserEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO hotels (name, city_id, address) VALUES ('%s', %s, '%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, city_id, address FROM hotels WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, city_id, address FROM hotels WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, city_id, address FROM hotels;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE hotels SET name = '%s', city_id = %s, address = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE hotels SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE hotels WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE hotels WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private UserEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String name;
    private Long cityId;
    private String address;

    public Hotel(Long id, String name, Long cityId, String adress) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.address = adress;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
