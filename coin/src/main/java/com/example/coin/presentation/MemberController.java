package com.example.coin.presentation;

import com.example.coin.application.MemberService;
import com.example.coin.application.UseRoomService;
import com.example.coin.presentation.dto.MemberRequestDto;
import com.example.coin.presentation.dto.MemberResponseDto;
import com.example.coin.presentation.dto.UseRoomResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;
    private UseRoomService useRoomService;

    @Autowired
    public MemberController(MemberService memberService, UseRoomService useRoomService) {
        this.memberService = memberService;
        this.useRoomService = useRoomService;
    }

    // 회원가입
    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResponseEntity<MemberResponseDto> createMember(
            @Valid @RequestBody MemberRequestDto memberRequestDto
    ) {
        MemberResponseDto memberResponseDto = memberService.generateMember(memberRequestDto);
        return ResponseEntity.ok(memberResponseDto);
    }

    // 회원 정보 조회
    @RequestMapping(value = "/members/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity<MemberResponseDto> getMemberInformation(
            @PathVariable("phoneNumber") String phoneNumber
    ) {
        MemberResponseDto memberResponseDto = memberService.getMemberInformation(phoneNumber);
        return ResponseEntity.ok(memberResponseDto);
    }

    //전체 회원 조회
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ResponseEntity<List<MemberResponseDto>> getAllMember() {
        return ResponseEntity.ok(memberService.getAllMember());
    }

    // 곡 수 추가 PATCH /members/{phoneNumber}/songs?count=3
    @RequestMapping(value = "/members/{phoneNumber}/songs", method = RequestMethod.PATCH)
    public ResponseEntity<MemberResponseDto> addSongCount(
            @PathVariable("phoneNumber") String phoneNumber,
            @RequestParam("count") int count
    ) {
        MemberResponseDto memberResponseDto = memberService.addSongCount(phoneNumber, count);
        return ResponseEntity.ok(memberResponseDto);
    }

    //곡 수 차감 + 방 선택 PATCH /members/{phoneNumber}/use?count=2&roomNum=1
    @RequestMapping(value = "/members/{phoneNumber}/use", method = RequestMethod.PATCH)
    public ResponseEntity<UseRoomResponseDto> useSongCount(
            @PathVariable("phoneNumber") String phoneNumber,
            @RequestParam("count") int count,
            @RequestParam("roomnum") int roomNum
    ) {
        UseRoomResponseDto useRoomResponseDto = useRoomService.useRoom(phoneNumber, count, roomNum);
        return ResponseEntity.ok(useRoomResponseDto);
    }

}
