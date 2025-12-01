package com.project.notice.presentation;

import com.project.notice.application.CommentService;
import com.project.notice.application.PostService;
import com.project.notice.domain.Member;
import com.project.notice.domain.Post;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    // 목록 -> 로그인 여부와 관계없이 누구나 볼 수 있음.
    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list";
    }

    // 글쓰기 폼
    @GetMapping("/new")
    public String createForm() {
        return "post/create";
    }

    // 글쓰기 처리
    @PostMapping("/new")
    public String create(
            @RequestParam String title,
            @RequestParam String content,
            HttpSession session
    ) {
        Member member = (Member) session.getAttribute("loginMember");
        postService.create(title, content, member);

        return "redirect:/posts";
    }

    // 상세보기 -> 로그인 여부와 관계없이 누구나 볼 수 있음.
    @GetMapping("/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ) {
        Post post = postService.viewPost(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.findByPostId(id));
        return "post/detail";
    }

    // 삭제
    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable Long id,
            HttpSession session
    ) {
        Member member = (Member) session.getAttribute("loginMember");
        postService.delete(id, member);
        return "redirect:/posts";
    }
}