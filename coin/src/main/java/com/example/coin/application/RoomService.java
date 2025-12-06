package com.example.coin.application;

import com.example.coin.domain.Room;
import com.example.coin.domain.RoomRepository;
import com.example.coin.domain.RoomStatus;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import com.example.coin.presentation.dto.RoomResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room useRoom(int roomNumber) {
        Room room = getRoomOrThrow(roomNumber);

        room.changeStatus(RoomStatus.USING);

        return room;
    }

    public Room changeRoomStatus(int roomNumber, String roomStatus) {
        Room room = getRoomOrThrow(roomNumber);
        String upperRoomStatus = roomStatus.toUpperCase();

        // 검증 + 변환
        RoomStatus newStatus = RoomStatus.from(roomStatus);
        room.changeStatus(newStatus);

        return room;
    }

    public List<RoomResponseDto> getAllRoom() {
        List<RoomResponseDto> roomResponseDtos = new ArrayList<>();

        for (Room room : roomRepository.findAllRooms()) {
            roomResponseDtos.add(new RoomResponseDto(room));
        }

        return roomResponseDtos;
    }

    private Room getRoomOrThrow(int roomNumber) {
        Room room = roomRepository.findRoomByNumber(roomNumber);
        if (room == null) {
            throw new BusinessException(ErrorCode.ROOM_NOT_FOUND);
        }
        return room;
    }
}
