package com.example.coin.infrastructure;

import com.example.coin.domain.Room;
import com.example.coin.domain.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ListRoomRepository implements RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    @PostConstruct
    public void initData() {
        saveRoom(new Room(1));
        saveRoom(new Room(2));
        saveRoom(new Room(3));
        saveRoom(new Room(4));
    }

    @Override
    public void saveRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Room findRoomByNumber(int number) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber() == number)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Room> findAllRooms() {
        return rooms;
    }
}
