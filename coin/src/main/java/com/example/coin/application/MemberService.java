package com.example.coin.application;

import com.example.coin.domain.Member;
import com.example.coin.domain.MemberRepository;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import com.example.coin.presentation.dto.MemberRequestDto;
import com.example.coin.presentation.dto.MemberResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponseDto generateMember(MemberRequestDto memberRequestDto) {
        String name = memberRequestDto.getName();
        String phoneNumber = memberRequestDto.getPhoneNumber();

        if (memberRepository.findByPhoneNumber(phoneNumber) != null) {
            throw new BusinessException(ErrorCode.DUPLICATE_PHONE);
        }

        Member member = new Member(name, phoneNumber);
        memberRepository.saveMember(member);

        return new MemberResponseDto(member);
    }

    public MemberResponseDto getMemberInformation(String phoneNumber) {
        Member member = getMemberOrThrow(phoneNumber);

        return new MemberResponseDto(member);
    }

    public MemberResponseDto addSongCount(String phoneNumber, int count) {
        Member member = getMemberOrThrow(phoneNumber);

        member.addSongCount(count);
        return new MemberResponseDto(member);
    }

    public Member decreaseSongCount(String phoneNumber, int count) {
        Member member = getMemberOrThrow(phoneNumber);

        member.useSongCount(count); // 도메인 행동

        return member;
    }

    public List<MemberResponseDto> getAllMember() {
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();

        for (Member member : memberRepository.findAllMembers()) {
            memberResponseDtos.add(new MemberResponseDto(member));
        }

        return memberResponseDtos;
    }

    private Member getMemberOrThrow(String phoneNumber) {
        Member member = memberRepository.findByPhoneNumber(phoneNumber);

        if (member == null) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }

        return member;
    }
}
