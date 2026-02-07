package com.example.coin.application;

import com.example.coin.domain.Member;
import com.example.coin.domain.MemberRepository;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import com.example.coin.presentation.dto.MemberRequestDto;
import com.example.coin.presentation.dto.MemberResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberRepository memberRepository;
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입이_성공한다() {
        MemberRequestDto dto = new MemberRequestDto("홍길동", "010-1234-5678");

        when(memberRepository.findByPhoneNumber("010-1234-5678")).thenReturn(null);

        MemberResponseDto response = memberService.generateMember(dto);

        assertEquals("홍길동", response.getName());
        verify(memberRepository).saveMember(any(Member.class));
    }

    @Test
    void 중복된_전화번호면_예외가_발생한다() {
        MemberRequestDto dto = new MemberRequestDto("철수", "010-1111-2222");

        when(memberRepository.findByPhoneNumber("010-1111-2222"))
                .thenReturn(new Member("existing", "010-1111-2222"));

        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> memberService.generateMember(dto)
        );

        assertEquals(ErrorCode.DUPLICATE_PHONE, ex.getErrorCode());
    }

    @Test
    void 회원정보조회가_성공한다() {
        Member member = new Member("영희", "010-2222-3333");
        when(memberRepository.findByPhoneNumber("010-2222-3333")).thenReturn(member);

        MemberResponseDto response = memberService.getMemberInformation("010-2222-3333");

        assertEquals("영희", response.getName());
        assertEquals("010-2222-3333", response.getPhoneNumber());
    }

    @Test
    void 존재하지_않는_회원조회시_예외가_발생한다() {
        when(memberRepository.findByPhoneNumber("000")).thenReturn(null);

        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> memberService.getMemberInformation("000")
        );

        assertEquals(ErrorCode.MEMBER_NOT_FOUND, ex.getErrorCode());
    }

    @Test
    void 곡수를_추가하면_정상적으로_증가한다() {
        Member member = new Member("민수", "010-5555-6666");
        member.addSongCount(5);

        when(memberRepository.findByPhoneNumber("010-5555-6666")).thenReturn(member);

        MemberResponseDto response = memberService.addSongCount("010-5555-6666", 3);

        assertEquals(8, response.getSongCount());
    }

    @Test
    void 곡사용이_성공하면_곡수가_감소한다() {
        Member member = new Member("철수", "010-7777-8888");
        member.addSongCount(10);

        when(memberRepository.findByPhoneNumber("010-7777-8888")).thenReturn(member);

        Member updated = memberService.decreaseSongCount("010-7777-8888", 4);

        assertEquals(6, updated.getSongCount());
    }

    @Test
    void 곡이_부족하면_예외가_발생한다() {
        Member member = new Member("철수", "010-7777-8888");
        member.addSongCount(2);

        when(memberRepository.findByPhoneNumber("010-7777-8888")).thenReturn(member);

        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> memberService.decreaseSongCount("010-7777-8888", 5)
        );

        assertEquals(ErrorCode.LACK_OF_SONG_COUNT, ex.getErrorCode());
    }
}
