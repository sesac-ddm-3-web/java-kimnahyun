package com.example.coin.domain;

import java.util.List;

public interface MemberRepository {
    void saveMember(Member member);
    Member findMemberByPhoneNumber(String phoneNumber);

    List<Member> findAllMembers();
}
