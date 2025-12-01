package com.project.notice.application;

import com.project.notice.domain.Member;
import com.project.notice.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final MemberJpaRepository memberJpaRepository;

    public LoginService(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    // 로그인
    public Member login(String username, String password) {

        Member member = memberJpaRepository.findByUsername(username);

        if (member == null) {
            return null;
        }

        if (!member.getPassword().equals(password)) {
            return null;
        }

        return member;
    }
}
