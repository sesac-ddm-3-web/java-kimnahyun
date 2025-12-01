package com.project.notice.application;

import com.project.notice.domain.Member;
import com.project.notice.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public MemberService(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    public boolean signup(String username, String password) {

        Member exists = memberJpaRepository.findByUsername(username);
        if (exists != null) {
            return false;
        }

        Member member = new Member(username, password);
        memberJpaRepository.save(member);
        return true;
    }
}