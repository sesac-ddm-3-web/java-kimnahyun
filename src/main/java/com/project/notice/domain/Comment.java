package com.project.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    // JPA가 접근 가능, 외부에서 직접 호출 불가
    protected Comment() {
    }

    public Comment(String content, Member author, Post post) {
        this.content = content;
        this.author = author;
        this.post = post;
    }
}