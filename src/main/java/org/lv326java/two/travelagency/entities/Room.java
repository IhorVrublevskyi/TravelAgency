package org.lv326java.two.travelagency.entities;

public class Room implements Entity {

    public static enum UserEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO rooms (room_number, hotel_id) VALUES (%s, %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, room_number, hotel_id FROM rooms WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, room_number, hotel_id FROM rooms WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, room_number, hotel_id FROM rooms;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE rooms SET room_number = %s, hotel_id = %s WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE rooms SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE rooms WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE rooms WHERE %s = '%s';");
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
    private Integer roomNumber;
    private Long hotelId;

    public Room(Long id, Integer roomNumber, Long hotelId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.hotelId = hotelId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
