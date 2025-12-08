package com.example.coin.presentation;

import com.example.coin.application.MemberService;
import com.example.coin.application.UseRoomService;
import com.example.coin.domain.Member;
import com.example.coin.domain.Room;
import com.example.coin.domain.RoomStatus;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import com.example.coin.presentation.dto.MemberRequestDto;
import com.example.coin.presentation.dto.MemberResponseDto;
import com.example.coin.presentation.dto.UseRoomResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
@Import(com.example.coin.global.GlobalExceptionHandler.class)
class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MemberService memberService;

    @MockBean
    UseRoomService useRoomService;

    @Test
    void 회원가입_성공() throws Exception {
        Member member = new Member("홍길동", "010-1234-5678");
        MemberResponseDto response = new MemberResponseDto(member);

        when(memberService.generateMember(any())).thenReturn(response);

        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {"name":"홍길동","phoneNumber":"010-1234-5678"}
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("홍길동"))
                .andExpect(jsonPath("$.phoneNumber").value("010-1234-5678"));
    }

    @Test
    void 회원가입_중복번호_예외() throws Exception {

        when(memberService.generateMember(any()))
                .thenThrow(new BusinessException(ErrorCode.DUPLICATE_PHONE));

        mvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {"name":"홍길동","phoneNumber":"010-1234-5678"}
                        """))
                .andExpect(status().isConflict())
                .andExpect(content().string("동일한 전화번호의 회원정보가 존재합니다."));
    }

    @Test
    void 회원조회_성공() throws Exception {
        MemberResponseDto response = new MemberResponseDto(
                new Member("영희", "010-2222-3333")
        );

        when(memberService.getMemberInformation("010-2222-3333")).thenReturn(response);

        mvc.perform(get("/members/010-2222-3333"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("영희"))
                .andExpect(jsonPath("$.phoneNumber").value("010-2222-3333"));
    }

    @Test
    void 회원조회_없음_예외() throws Exception {
        when(memberService.getMemberInformation(anyString()))
                .thenThrow(new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        mvc.perform(get("/members/000"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("없는 전화번호 입니다. 회원가입을 진행하세요."));
    }

    @Test
    void 곡수추가_성공() throws Exception {
        Member member = new Member("철수", "010-7777-8888");
        member.addSongCount(5);

        MemberResponseDto response = new MemberResponseDto(member);

        when(memberService.addSongCount("010-7777-8888", 3))
                .thenReturn(response);

        mvc.perform(patch("/members/010-7777-8888/songs?count=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songCount").value(5));
    }

    @Test
    void 곡사용_성공() throws Exception {
        Member member = new Member("홍길동", "010-1111-2222");
        Room room = new Room(1);

        UseRoomResponseDto response = new UseRoomResponseDto(member, room);

        when(useRoomService.useRoom("010-1111-2222", 2, 1))
                .thenReturn(response);

        mvc.perform(patch("/members/010-1111-2222/use?count=2&roomnum=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomNumber").value(1));
    }
}
