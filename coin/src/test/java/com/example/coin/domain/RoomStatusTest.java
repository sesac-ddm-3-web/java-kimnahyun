package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoomStatusTest {

    @Test
    void 문자열로부터_ENUM_변환_성공() {
        assertThat(RoomStatus.from("using")).isEqualTo(RoomStatus.USING);
        assertThat(RoomStatus.from("finished")).isEqualTo(RoomStatus.FINISHED);
        assertThat(RoomStatus.from("Inspection")).isEqualTo(RoomStatus.INSPECTION);
    }

    @Test
    void 잘못된문자열이면_예외() {
        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> RoomStatus.from("abc")
        );

        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.INVALID_ROOM_STATUS);
    }
}
