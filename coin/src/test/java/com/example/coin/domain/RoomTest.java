package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoomTest {

    @Test
    void 기본생성시_FINISHED_상태다() {
        Room room = new Room(1);

        assertThat(room.getStatus()).isEqualTo(RoomStatus.FINISHED);
        assertThat(room.getRoomNumber()).isEqualTo(1);
    }

    @Test
    void 상태변경_성공() {
        Room room = new Room(1);

        room.changeStatus(RoomStatus.USING);

        assertThat(room.getStatus()).isEqualTo(RoomStatus.USING);
    }

    @Test
    void INSPECTION에서_USING으로_바꿀때_예외() {
        Room room = new Room(1);

        room.changeStatus(RoomStatus.INSPECTION);

        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> room.changeStatus(RoomStatus.USING)
        );

        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.ROOM_UNAVAILABLE);
    }
}
