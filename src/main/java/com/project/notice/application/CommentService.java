package com.project.notice.application;

import com.project.notice.domain.Comment;
import com.project.notice.infrastructure.CommentJpaRepository;
import com.project.notice.infrastructure.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import com.project.notice.domain.Member;
import com.project.notice.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentService {
    private final CommentJpaRepository commentJpaRepository;
    private final PostJpaRepository postJpaRepository;

    @Autowired
    public CommentService(CommentJpaRepository commentJpaRepository, PostJpaRepository postJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
        this.postJpaRepository = postJpaRepository;
    }

    public void add(Long postId, String content, Member author) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
        Comment comment = new Comment(content, author, post);
        commentJpaRepository.save(comment);
    }

    public List<Comment> findByPostId(Long postId) {
        return commentJpaRepository.findByPostId(postId);
    }

    public void delete(Long commentId, Long postId, Member member) {
        Comment comment = commentJpaRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("게시글 없음"));

        if (!comment.getAuthor().getId().equals(member.getId())) {
            return;
        }

        commentJpaRepository.delete(comment);
    }
}