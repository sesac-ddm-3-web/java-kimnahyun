package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Room {
    private static final AtomicLong sequence = new AtomicLong(0L);

    Long id;
    int roomNumber;
    RoomStatus status;

    public Room(int roomNumber) {
        this.id = sequence.incrementAndGet();
        this.roomNumber = roomNumber;
        this.status = RoomStatus.FINISHED;
    }

    public void changeStatus(RoomStatus newStatus) {
        if (this.status == RoomStatus.INSPECTION && newStatus == RoomStatus.USING) {
            throw new BusinessException(ErrorCode.ROOM_UNAVAILABLE);
        }

        this.status = newStatus;
    }
}
