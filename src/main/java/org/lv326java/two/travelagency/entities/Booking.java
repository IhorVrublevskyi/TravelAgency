package org.lv326java.two.travelagency.entities;

import java.sql.Date;

public class Booking implements Entity {

    public static enum BookingEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO bookings (user_id, room_id, date_checkin, date_checkout) VALUES (%s, %s, '%s', '%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, user_id, room_id, date_checkin, date_checkout FROM bookings WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, user_id, room_id, date_checkin, date_checkout FROM bookings WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, user_id, room_id, date_checkin, date_checkout FROM bookings;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE bookings SET user_id = %s, room_id = %s, date_checkin = '%s', date_checkout = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE bookings SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE bookings WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE bookings WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private BookingEntityQueries(SqlQueries sqlQuery, String query) {
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
    private Long userId;
    private Long roomId;
    private Date dateCheckin;
    private Date dateCheckout;

    public Booking(Long id, Long userId, Long roomId, Date dateCheckin, Date dateCheckout) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(Date dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public Date getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(Date dateCheckout) {
        this.dateCheckout = dateCheckout;
    }
}
