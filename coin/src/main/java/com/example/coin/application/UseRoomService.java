package com.example.coin.application;

import com.example.coin.domain.Member;
import com.example.coin.domain.Room;
import com.example.coin.presentation.dto.UseRoomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseRoomService {

    private final MemberService memberService;
    private final RoomService roomService;

    @Autowired
    public UseRoomService(MemberService memberService, RoomService roomService) {
        this.memberService = memberService;
        this.roomService = roomService;
    }

    public UseRoomResponseDto useRoom(String phoneNumber, int count, int roomNumber) {
        Room room = roomService.useRoom(roomNumber);
        Member member = memberService.decreaseSongCount(phoneNumber, count);

        return new UseRoomResponseDto(member, room);
    }
}
