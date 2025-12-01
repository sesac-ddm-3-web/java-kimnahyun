package com.project.notice.presentation;

import com.project.notice.application.CommentService;
import com.project.notice.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public String add(@RequestParam Long postId,
                      @RequestParam String content,
                      HttpSession session) {

        Member member = (Member) session.getAttribute("loginMember");
        commentService.add(postId, content, member);

        return "redirect:/posts/" + postId;
    }

    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable Long id,
            @RequestParam Long postId,
            HttpSession session
    ) {
        Member member = (Member) session.getAttribute("loginMember");
        commentService.delete(id, postId, member);

        return "redirect:/posts/" + postId;
    }
}