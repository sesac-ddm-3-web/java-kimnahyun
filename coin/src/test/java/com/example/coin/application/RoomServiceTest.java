package com.example.coin.application;

import com.example.coin.domain.Room;
import com.example.coin.domain.RoomRepository;
import com.example.coin.domain.RoomStatus;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomServiceTest {

    private RoomRepository roomRepository;
    private RoomService roomService;

    @BeforeEach
    void setUp() {
        roomRepository = mock(RoomRepository.class);
        roomService = new RoomService(roomRepository);
    }

    @Test
    void 방사용_성공() {
        Room room = new Room(1);

        when(roomRepository.findRoomByNumber(1)).thenReturn(room);

        Room result = roomService.useRoom(1);

        assertThat(result.getStatus()).isEqualTo(RoomStatus.USING);
    }


    @Test
    void 방없으면_예외() {
        when(roomRepository.findRoomByNumber(999)).thenReturn(null);

        BusinessException ex = org.junit.jupiter.api.Assertions.assertThrows(
                BusinessException.class,
                () -> roomService.useRoom(999)
        );

        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.ROOM_NOT_FOUND);
    }

    @Test
    void 방상태변경_성공() {
        Room room = new Room(2);
        when(roomRepository.findRoomByNumber(2)).thenReturn(room);

        Room changed = roomService.changeRoomStatus(2, "inspection");

        assertThat(changed.getStatus()).isEqualTo(RoomStatus.INSPECTION);
    }

    @Test
    void 방상태_잘못입력시_예외() {
        Room room = new Room(3);
        when(roomRepository.findRoomByNumber(3)).thenReturn(room);

        BusinessException ex = org.junit.jupiter.api.Assertions.assertThrows(
                BusinessException.class,
                () -> roomService.changeRoomStatus(3, "INVALID")
        );

        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ROOM_STATUS);
    }

    @Test
    void 전체방조회() {
        Room r1 = new Room(1);
        Room r2 = new Room(2);

        when(roomRepository.findAllRooms()).thenReturn(List.of(r1, r2));

        var list = roomService.getAllRoom();

        assertThat(list).hasSize(2);
        assertThat(list.get(0).getRoomNumber()).isEqualTo(1);
    }
}
