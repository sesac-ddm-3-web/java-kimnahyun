package com.example.coin.infrastructure;

import com.example.coin.domain.Member;
import com.example.coin.domain.MemberRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<Member> findAllMembers() {
        return new ArrayList<>(members.values());
    }

    @PostConstruct
    public void initData() {
        saveMember(new Member("김가가", "010-1234-5678"));
        saveMember(new Member("이나나", "010-2345-5678"));
        saveMember(new Member("최다다", "010-3456-5678"));
        saveMember(new Member("박라라", "010-4567-5678"));
        saveMember(new Member("강마마", "010-5678-5678"));
    }
}
