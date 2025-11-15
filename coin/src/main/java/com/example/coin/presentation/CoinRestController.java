package com.example.coin.presentation;

import com.example.coin.application.CoinService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 곡 수 추가 /coin/add?phonenum=010-2345-5678&count=3
    @RequestMapping(value = "/coin/add", method = RequestMethod.PATCH)
    public ResponseEntity<MemberResponseDto> addSongCount(
            @RequestParam("phonenum") String phoneNumber,
            @RequestParam("count") int count
    ) {
        MemberResponseDto memberResponseDto = coinService.addSongCount(phoneNumber, count);
        return ResponseEntity.ok(memberResponseDto);
    }

    //곡 수 차감 /coin/use?phonenum=010-2345-5678&count=2
    @RequestMapping(value = "/coin/use", method = RequestMethod.PATCH)
    public ResponseEntity<MemberResponseDto> useSongCount(
            @RequestParam("phonenum") String phoneNumber,
            @RequestParam("count") int count
    ) {
        MemberResponseDto memberResponseDto = coinService.decreaseSongCount(phoneNumber, count);
        return ResponseEntity.ok(memberResponseDto);
    }
}

