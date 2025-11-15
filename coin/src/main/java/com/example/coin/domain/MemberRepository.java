package com.example.coin.domain;

public interface MemberRepository {

    void saveMember(Member member);
    Member findMemberByPhoneNumber(String phoneNumber);
}
