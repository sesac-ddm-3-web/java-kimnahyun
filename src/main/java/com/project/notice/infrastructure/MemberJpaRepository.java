package com.project.notice.infrastructure;

import com.project.notice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
