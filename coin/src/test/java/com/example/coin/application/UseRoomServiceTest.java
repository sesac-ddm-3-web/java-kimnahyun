package com.example.coin.application;

import com.example.coin.domain.Member;
import com.example.coin.domain.Room;
import com.example.coin.domain.RoomStatus;
import com.example.coin.presentation.dto.UseRoomResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class UseRoomServiceTest {

    private MemberService memberService;
    private RoomService roomService;
    private UseRoomService useRoomService;

    @Test
    void 방사용_곡사용_성공() {
        memberService = mock(MemberService.class);
        roomService = mock(RoomService.class);
        useRoomService = new UseRoomService(memberService, roomService);

        Room room = new Room(1);
        Member member = new Member("홍길동", "010-1234-5678");
        member.addSongCount(10);

        when(roomService.useRoom(1)).thenReturn(room);
        when(memberService.decreaseSongCount("010-1234-5678", 3))
                .thenReturn(member);

        UseRoomResponseDto result = useRoomService.useRoom("010-1234-5678", 3, 1);

        assertThat(result.getRoomNumber()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("홍길동");
    }
}
