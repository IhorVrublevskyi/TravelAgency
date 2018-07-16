package org.lv326java.two.travelagency.services;

import org.lv326java.two.travelagency.dao.RoomDao;
import org.lv326java.two.travelagency.dto.RoomDto;
import org.lv326java.two.travelagency.entities.Room;

public class RoomService {

    private RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public RoomService() {
        this.roomDao = new RoomDao();
    }

    public boolean insert(RoomDto roomDto) {
        return roomDao.insert(new Room(
                null,
                Integer.parseInt(roomDto.getNumber()),
                Long.parseLong(roomDto.getHotelId())
        ));
    }
}
