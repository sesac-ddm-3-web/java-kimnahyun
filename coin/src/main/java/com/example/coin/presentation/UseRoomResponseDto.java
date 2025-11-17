package com.example.coin.presentation;

import com.example.coin.domain.Member;
import com.example.coin.domain.Room;
import com.example.coin.domain.RoomStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UseRoomResponseDto {
    String name;
    String phoneNumber;
    int songCount;
    int roomNumber;
    RoomStatus status;

    public UseRoomResponseDto(Member member, Room room) {
        this.name = member.getName();
        this.phoneNumber = member.getPhoneNumber();
        this.songCount = member.getSongCount();
        this.roomNumber = room.getRoomNumber();
        this.status = room.getStatus();
    }
}
