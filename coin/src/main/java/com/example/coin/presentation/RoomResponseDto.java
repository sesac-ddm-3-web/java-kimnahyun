package com.example.coin.presentation;

import com.example.coin.domain.Room;
import com.example.coin.domain.RoomStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponseDto {
    Long id;
    int roomNumber;
    RoomStatus status;

    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.roomNumber = room.getRoomNumber();
        this.status = room.getStatus();
    }
}
