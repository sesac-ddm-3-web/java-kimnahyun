package com.example.coin.application;

import com.example.coin.domain.Member;
import com.example.coin.domain.MemberRepository;
import com.example.coin.presentation.MemberRequestDto;
import com.example.coin.presentation.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {

    private MemberRepository memberRepository;

    @Autowired
    CoinService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponseDto generateMember(MemberRequestDto memberRequestDto) {
        String name = memberRequestDto.getName();
        String phoneNumber = memberRequestDto.getPhoneNumber();

        Member member = new Member(name, phoneNumber);

        memberRepository.saveMember(member);

        MemberResponseDto memberResponseDto = new MemberResponseDto(member);

        return memberResponseDto;
    }

    public MemberResponseDto getMemberInformation(String phoneNumber) {
        MemberResponseDto memberResponseDto = new MemberResponseDto(memberRepository.findMemberByPhoneNumber(phoneNumber));
        return memberResponseDto;
    }

    public MemberResponseDto addSongCount(String phoneNumber, int count) {
        Member member = memberRepository.findMemberByPhoneNumber(phoneNumber);
        member.setSongCount(member.getSongCount() + count);
        return new MemberResponseDto(member);
    }

    public MemberResponseDto decreaseSongCount(String phoneNumber, int count) {
        Member member = memberRepository.findMemberByPhoneNumber(phoneNumber);
        member.setSongCount(member.getSongCount() - count);
        return new MemberResponseDto(member);
    }
}
