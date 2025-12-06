package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;

public enum RoomStatus {
    USING,
    FINISHED,
    INSPECTION;

    public static RoomStatus from(String status) {
        try {
            return RoomStatus.valueOf(status.toUpperCase());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.INVALID_ROOM_STATUS);
        }
    }
}
