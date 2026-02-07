package com.example.coin.presentation.dto;

import com.example.coin.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    Long id;
    String name;
    String phoneNumber;
    int songCount;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.phoneNumber = member.getPhoneNumber();
        this.songCount = member.getSongCount();
    }
}
