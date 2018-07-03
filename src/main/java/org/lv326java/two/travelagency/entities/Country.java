package org.lv326java.two.travelagency.entities;

public class Country implements Entity {

    public static enum CountryEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO countries (name) VALUES ('%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name FROM countries WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name FROM countries WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name FROM countries;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE countries SET name = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE countries SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE countries WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE countries WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private CountryEntityQueries(SqlQueries sqlQuery, String query) {
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

    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
