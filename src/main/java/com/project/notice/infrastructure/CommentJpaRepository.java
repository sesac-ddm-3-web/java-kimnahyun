package com.project.notice.infrastructure;

import com.project.notice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
