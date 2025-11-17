package com.example.coin.domain;

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

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
