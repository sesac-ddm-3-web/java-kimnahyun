package com.example.coin.infrastructure;

import com.example.coin.domain.Member;
import com.example.coin.domain.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MapMemberRepository implements MemberRepository {

    private Map<String, Member> members = new HashMap<>();

    @Override
    public void saveMember(Member member) {
        members.put(member.getPhoneNumber(), member);
    }

    @Override
    public Member findMemberByPhoneNumber(String phoneNumber) {
        return members.get(phoneNumber);
    }
}
