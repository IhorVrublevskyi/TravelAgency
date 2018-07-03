package org.lv326java.two.travelagency.entities;

public class City implements Entity {

    public static enum CityEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO cities (name, county_id) VALUES ('%s', %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, county_id FROM cities WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, county_id FROM cities WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, county_id FROM cities;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE cities SET name = '%s', county_id = %s WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE cities WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE cities WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private CityEntityQueries(SqlQueries sqlQuery, String query) {
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
    private Long countryId;

    public City(Long id, String name, Long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
