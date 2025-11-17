package com.example.coin.presentation;

import com.example.coin.application.CoinService;
import com.example.coin.domain.Member;
import com.example.coin.domain.Room;
import com.example.coin.domain.RoomRepository;
import com.example.coin.domain.RoomStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoinRestController {

    private CoinService coinService;

    @Autowired
    CoinRestController(CoinService coinService) {
        this.coinService = coinService;
    }

    // 회원가입
    @RequestMapping(value = "/coin/member", method = RequestMethod.POST)
    public ResponseEntity<MemberResponseDto> createMember(
            @Valid @RequestBody MemberRequestDto memberRequestDto
    ) {
        MemberResponseDto memberResponseDto = coinService.generateMember(memberRequestDto);
        return ResponseEntity.ok(memberResponseDto);
    }

    // 회원 정보 조회
    @RequestMapping(value = "/coin/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity<MemberResponseDto> getMemberInformation(
            @PathVariable String phoneNumber
    ) {
        MemberResponseDto memberResponseDto = coinService.getMemberInformation(phoneNumber);
        return ResponseEntity.ok(memberResponseDto);
    }

    //전체 회원 조회
    @RequestMapping(value = "/coin/members", method = RequestMethod.GET)
    public ResponseEntity<List<MemberResponseDto>> getAllMember() {
        return ResponseEntity.ok(coinService.getAllMember());
    }

    // 곡 수 추가 /coin/add?phonenum=010-2345-5678&count=3
    @RequestMapping(value = "/coin/add", method = RequestMethod.PATCH)
    public ResponseEntity<MemberResponseDto> addSongCount(
            @RequestParam("phonenum") String phoneNumber,
            @RequestParam("count") int count
    ) {
        MemberResponseDto memberResponseDto = coinService.addSongCount(phoneNumber, count);
        return ResponseEntity.ok(memberResponseDto);
    }

    //곡 수 차감 + 방 선택 /coin/use?phonenum=010-2345-5678&count=2&roomnum=1
    @RequestMapping(value = "/coin/use", method = RequestMethod.PATCH)
    public ResponseEntity<UseRoomResponseDto> useSongCount(
            @RequestParam("phonenum") String phoneNumber,
            @RequestParam("count") int count,
            @RequestParam("roomnum") int roomNum
    ) {
        Room room = coinService.useRoom(roomNum);
        Member member = coinService.decreaseSongCount(phoneNumber, count);

        UseRoomResponseDto useRoomResponseDto = new UseRoomResponseDto(member, room);
        return ResponseEntity.ok(useRoomResponseDto);
    }

    // 방 상태 변경 /coin/room?roomnum=2&status=inspection
    @RequestMapping(value = "/coin/room", method = RequestMethod.PATCH)
    public ResponseEntity<RoomResponseDto> changeRoomStatus(
            @RequestParam("roomnum") int roomNum,
            @RequestParam("status") String roomStatus
            ) {
        Room changedRoom = coinService.changeRoomStatus(roomNum, roomStatus);
        RoomResponseDto roomResponseDto = new RoomResponseDto(changedRoom);

        return ResponseEntity.ok(roomResponseDto);
    }

    //방 전체 조회
    @RequestMapping(value = "/coin/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<RoomResponseDto>> getAllRoom() {
        return ResponseEntity.ok(coinService.getAllRoom());
    }
}