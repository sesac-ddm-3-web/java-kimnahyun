package com.project.notice.application;

import com.project.notice.domain.Member;
import com.project.notice.domain.Post;
import com.project.notice.infrastructure.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostJpaRepository postJpaRepository;

    public PostService(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }

    public List<Post> findAll() {
        return postJpaRepository.findAll();
    }

    public void create(String title, String content, Member member) {
        Post post = new Post(title, content, member);
        postJpaRepository.save(post);
    }

    public Post viewPost(Long id) {
        Post post = postJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        post.increaseViews();
        return postJpaRepository.save(post);
    }

    public void delete(Long id, Member member) {
        Post post = postJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));

        if (!post.getAuthor().getId().equals(member.getId())) {
            return;
        }

        postJpaRepository.delete(post);
    }
}
