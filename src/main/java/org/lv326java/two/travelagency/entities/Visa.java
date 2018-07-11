package org.lv326java.two.travelagency.entities;

import java.sql.Date;

public class Visa implements Entity {

    public static enum VisaEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO visas (country_id, user_id, date_of_init, date_of_expired) VALUES (%s, %s, '%s', '%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, date_of_init, date_of_expired, country_id, user_id FROM visas WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, country_id, user_id, date_of_init, date_of_expired FROM visas WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, date_of_init, date_of_expired, country_id, user_id FROM visas;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE visas SET date_of_init = '%s', date_of_expired = '%s', country_id = %s, user_id = %s WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE visas SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM visas WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM visas WHERE %s = '%s';");

        private SqlQueries sqlQuery;
        private String query;

        private VisaEntityQueries(SqlQueries sqlQuery, String query) {
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
    private Long countryId;
    private Long userId;
    private Date dateOfInit;
    private Date dateOfExpired;

    public Visa(Long id, Long countryId, Long userId, Date dateOfInit, Date dateOfExpired) {
        this.id = id;
        this.countryId = countryId;
        this.userId = userId;
        this.dateOfInit = dateOfInit;
        this.dateOfExpired = dateOfExpired;
    }

    @Override
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDateOfInit() {
        return dateOfInit;
    }

    public void setDateOfInit(Date dateOfInit) {
        this.dateOfInit = dateOfInit;
    }

    public Date getDateOfExpired() {
        return dateOfExpired;
    }

    public void setDateOfExpired(Date dateOfExpired) {
        this.dateOfExpired = dateOfExpired;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", userId=" + userId +
                ", dateOfInit=" + dateOfInit +
                ", dateOfExpired=" + dateOfExpired +
                '}';
    }
}
