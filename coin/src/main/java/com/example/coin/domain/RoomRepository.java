package com.example.coin.domain;

import java.util.List;

public interface RoomRepository {
    void saveRoom(Room room);

    Room findRoomByNumber(int number);

    List<Room> findAllRooms();
}
