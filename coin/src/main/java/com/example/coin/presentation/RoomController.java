package com.example.coin.presentation;

import com.example.coin.application.RoomService;
import com.example.coin.domain.Room;
import com.example.coin.presentation.dto.RoomResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // 방 상태 변경 PATCH /rooms/{roomNum}/status?value=inspection
    @RequestMapping(value = "/rooms/{roomNum}/status", method = RequestMethod.PATCH)
    public ResponseEntity<RoomResponseDto> changeRoomStatus(
            @PathVariable("roomNum") int roomNum,
            @RequestParam("status") String roomStatus
    ) {
        Room changedRoom = roomService.changeRoomStatus(roomNum, roomStatus);
        RoomResponseDto roomResponseDto = new RoomResponseDto(changedRoom);

        return ResponseEntity.ok(roomResponseDto);
    }

    //방 전체 조회
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<RoomResponseDto>> getAllRoom() {
        return ResponseEntity.ok(roomService.getAllRoom());
    }
}

